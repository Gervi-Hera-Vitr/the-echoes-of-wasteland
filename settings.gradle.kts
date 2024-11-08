@file:Suppress("UnstableApiUsage")

pluginManagement {
  val useJavaVer: String by settings

  val jupiterVersion: String by settings
  val assertjVersion: String by settings
  val jacocoToolVersion: String by settings

  val toolchainsFoojayResolverVersion: String by settings
  val ioFreeFairVersion: String by settings

  val develocityVersion: String by settings

  repositories {
    gradlePluginPortal()
    mavenCentral()
    google()
  }

//      https://docs.gradle.org/current/userguide/plugins.html
//      https://plugins.gradle.org/
  plugins {

//      https://docs.gradle.org/current/userguide/application_plugin.html
    application

//      https://docs.gradle.org/current/userguide/jacoco_plugin.html
    jacoco

//        https://docs.freefair.io/gradle-plugins/current/reference/
    id("io.freefair.lombok") version ioFreeFairVersion


//        https://docs.gradle.org/current/userguide/toolchains.html
    id("org.gradle.toolchains.foojay-resolver-convention") version toolchainsFoojayResolverVersion

    id("com.gradle.develocity") version develocityVersion
  }
}

plugins {
  id("com.gradle.develocity")
}

//        https://docs.gradle.com/develocity/gradle-plugin/current/
develocity {
  buildScan {
    termsOfUseUrl.set("https://gradle.com/help/legal-terms-of-use")
    termsOfUseAgree.set("yes")
    publishing.onlyIf { it.buildResult.failures.isNotEmpty() }
  }
}
