import org.gradle.api.tasks.testing.logging.TestExceptionFormat.FULL
import org.gradle.api.tasks.testing.logging.TestLogEvent.*
import org.slf4j.LoggerFactory

val useJavaVer: String by project

val jupiterVersion: String by project
val assertjVersion: String by project
val jacocoToolVersion: String by project
val toolchainsFoojayResolverVersion: String by project

private val log by lazy { LoggerFactory.getLogger(group.toString()) }

log.warn(
  """

    Welcome to {}!
    Build:     {};
    Java/JVM:  {};
    OS:        {} ({});
    Jacoco:    {};

    """.trimIndent(),
  description,
  version,
  System.getProperty("java.version"),
  System.getProperty("os.name"),
  System.getProperty("os.arch"),
  jacoco.toolVersion
)

plugins {
  application
  jacoco

  id("io.freefair.lombok")
}

repositories {
  gradlePluginPortal()
  mavenCentral()
}

dependencies {
  testImplementation(platform("org.junit:junit-bom:$jupiterVersion"))
  testImplementation(platform("org.assertj:assertj-bom:$assertjVersion"))

  testImplementation("org.assertj:assertj-core")
  testImplementation("org.junit.jupiter:junit-jupiter-api")
  testImplementation("org.junit.jupiter:junit-jupiter-params")
}

java {
  toolchain {
    languageVersion = JavaLanguageVersion.of(useJavaVer)
    vendor = JvmVendorSpec.ADOPTIUM
  }
}

application {
  mainClass = "me.lugaru.gaming.Main"
}


tasks.withType<Test>().configureEach {
  useJUnitPlatform()

  testLogging {
    showStandardStreams = true
    showStackTraces = true
    exceptionFormat = FULL
    events = setOf(STARTED, PASSED, SKIPPED, FAILED, STANDARD_OUT, STANDARD_ERROR)
  }
  systemProperty("gradle.build.dir", layout.buildDirectory)
  systemProperties = System.getProperties().asIterable().associate { it.key.toString() to it.value }

  finalizedBy(tasks.jacocoTestReport)

  reports {
    html.required.set(true)
    junitXml.required.set(true)
  }
}

tasks.withType<JacocoReport> {
  reports {
    xml.required.set(true)
    html.required.set(true)
    csv.required.set(false)
  }
  finalizedBy(tasks.jacocoTestCoverageVerification)
}

tasks.withType<JacocoCoverageVerification> {
  violationRules {
    rule {
      limit {
        minimum = "0.5".toBigDecimal()
      }
    }
    rule {
      enabled = false
      element = "CLASS"
      includes = listOf("me.lugaru.gaming.*")
      limit {
        counter = "LINE"
        value = "TOTALCOUNT"
        minimum = "0.0".toBigDecimal()

      }
    }
  }
}


tasks.withType<Wrapper> {
  distributionType = Wrapper.DistributionType.ALL
}


/**
 * Registering a temporary custom task of inspecting my toolchain.
 */
tasks.register<IntrospectingToolchainTask>("show-toolchain")

/**
 * # IntrospectingToolchainTask
 *
 * _Thus is a custom task not used otherwise to show which toolchain is being used._
 *
 * This can be removed.
 */
@Suppress("LeakingThis")
abstract class IntrospectingToolchainTask : DefaultTask() {

  private val logging by lazy { LoggerFactory.getLogger(this.javaClass) }

  @get:Nested
  abstract val launcher: Property<JavaLauncher>

  init {
    val toolchain = project.extensions.getByType<JavaPluginExtension>().toolchain
    val defaultLauncher = javaToolchainService.launcherFor(toolchain)
    launcher.convention(defaultLauncher)
  }

  @TaskAction
  fun showConfiguredToolchain() {
    logging.warn(
      """

            Inspecting the default toolchain: as specified in the custom task ({})
            Installation path:  {}
            Executable path:    {}

            Note: inspect the toolchains with `gradle -q javaToolchains`

        """.trimIndent(),
      logging.name,
      launcher.get().metadata.installationPath,
      launcher.get().executablePath
    )
  }

  @get:Inject
  protected abstract val javaToolchainService: JavaToolchainService
}