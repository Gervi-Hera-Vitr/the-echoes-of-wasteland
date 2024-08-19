---
layout: single
author: Lugaru
classes: wide
title: "Echoes of the Wasteland Library Development"
description: "These are the steps we take to develop the Echoes of the Wasteland library."
category: support
date: 2024-08-19 08:37:03 -0400
permalink: /development/
toc: true
toc_label: "Developer's Guide"
toc_icon: "fas fa-book-open"
toc_sticky: true
author_profile: true
sidebar:
  - title: "Box Setup"
    image: rezs/images/LocalDevBadge.png
    image_alt: "The Echoes Protagonist Badge"
    text: "How do we setup the development environment for the Echoes of the Wasteland?"
  - title: "Java Setup"
    text: "Configuring local Java development environment."
  - title: "Python Setup"
    text: "Configuring local Python development environment."
header:
  overlay_image: rezs/images/TheEchoesOfTheWasteland.png  
  show_overlay_excerpt: true
  caption: "The Echoes of the Wasteland"
  excerpt: Guide to contribute code to the Echoes of the Wasteland library.
---

_{{page.description}}_

Having [_the documentation part of things figured out over here_]({{ site.baseurl }}/support/ "Support") now we can set up for coding!

ToDo: `rdd13r` - document all this from Anominous and Lugary boxes plase.

## Local Box Setup Overview

We use:

* [**_GitHub Actions_**](https://docs.github.com/en/actions "GitHub Actions") for build, test, deploy and publish pipelines;
* [**_SDK Man_**](https://sdkman.io "SDK Man") for local JVM SDKs and JVM language dependencies:
  * [**_Gradle_**](https://gradle.org "Gradle") for component definition manifest;
  * [**_JDK LTS_**](https://adoptium.net/ "JDK LTS") for all component development;
  * (Optional) [**_Kotlin_**](https://kotlinlang.org "Kotlin") for future component development;
* [**_`asdf`_**](https://asdf-vm.com "asdf") for local Ruby SDKs and Jekyll dependencies:
  * [**_Ruby_**](https://www.ruby-lang.org "Ruby") for all component development;
  * [**_Jekyll_**](https://jekyllrb.com "Jekyll") for component definition manifest;
  * [**_Bundler_**](https://bundler.io "Bundler") for component development;
* [**_Conda_**](https://conda.io/projects/conda/en/latest/user-guide/install/index.html "Conda") for component development:
  * [**_Python_**](https://www.python.org "Python") for all component development;
* (Optional) [**_Volta_**](https://volta.sh "Volta") for future component development:
  * [**_Node.js_**](https://nodejs.org "Node.js") for all component development;
  * [**_Yarn_**](https://yarnpkg.com "Yarn") for component development;
* (Optional) [**_Docker_**](https://www.docker.com "Docker") for component development:
  * [**_Docker Desktop_**](https://www.docker.com "Docker Desktop") for all component development;
  * [**_Colima_**](https://colima.dev "Colima") for component development.

## Ops!




Tada! You're all set.

