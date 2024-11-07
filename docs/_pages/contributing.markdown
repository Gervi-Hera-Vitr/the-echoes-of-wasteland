---
layout: single
author: Lugaru
classes: wide
title: "Echoes of the Wasteland Library Development"
description: "These are the steps we take to develop the Echoes of Wasteland library."
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
  text: "How do we setup the development environment for the Echoes of Wasteland?"
- title: "Java Setup"
  text: "Configuring local Java development environment."
- title: "Python Setup"
  text: "Configuring local Python development environment."
- nav: development
header:
  overlay_image: rezs/images/TheEchoesOfTheWasteland.png  
  show_overlay_excerpt: true
  caption: "The Echoes of Wasteland"
  excerpt: Guide to contribute code to the Echoes of Wasteland library.
---

_{{page.description}}_

Having [_the documentation part of things figured out over here_]({{ site.baseurl }}/support/ "Support") now we can set up for coding!

ToDo: `rdd13r` - document all this from Anominous and Lugary boxes plase.

## Local Box Setup Overview

We use:

* [**_GitHub Actions_**](https://docs.github.com/en/actions "GitHub Actions") for build, test, deploy and publish pipelines;
* Oh, My Zsh for shell configuration and plugin management;
* [**_SDK Man_**](https://sdkman.io "SDK Man") for local JVM SDKs and JVM language dependencies:
  * [**_Gradle_**](https://gradle.org "Gradle") software project definition manifest;
  * [**_JDK LTS_**](https://adoptium.net/ "JDK LTS") for Java compiler;
  * (Optional) [**_Kotlin_**](https://kotlinlang.org "Kotlin") for Kotlin compiler;
* [**_`asdf`_**](https://asdf-vm.com "asdf") for local SDKs, i.e., Ruby, Jekyll, and dependencies:
  * [**_Ruby_**](https://www.ruby-lang.org "Ruby") for Jekyll and Bundler;
  * [**_Jekyll_**](https://jekyllrb.com "Jekyll") for GitHub Pages;
  * [**_Bundler_**](https://bundler.io "Bundler") for local site development;
* [**_Conda_**](https://conda.io/projects/conda/en/latest/user-guide/install/index.html "Conda") for AI/ML component development:
  * [**_Python_**](https://www.python.org "Python") for native Python SDKs and environment management;
* (Optional) [**_Volta_**](https://volta.sh "Volta") for TypeScript and Node.js UI/UX development:
  * [**_Node.js_**](https://nodejs.org "Node.js") for managed Node runtime;
  * [**_Yarn_**](https://yarnpkg.com "Yarn") for a nicer package manager;
* (Optional) [**_Docker_**](https://www.docker.com "Docker") for proper local containerization and canned builders; 
  * [**_Docker Desktop_**](https://www.docker.com "Docker Desktop") the preferred distribution with classes, labs and workspaces;
  * [**_Colima_**](https://colima.dev "Colima") for an alternative provisioning of Linux kernel and event `k8s` as well.
*

## Ops!

Automation is a critical part of our manifest because nobody wants to tinker with stuff manually.
We are using [GitHub Actions](https://docs.github.com/en/actions "GitHub Actions") to automate Ops.
This doesn't affect the project manifest itself, which the Ops use to build the site.
Actions live in the `.github/workflows` folder and are triggered by the GitHub Actions hooks.
Look to familiarize yourself with the workflows we make.

## Local Shell Setup

Shell is our primary IDE as it has always been.
Interpreter is `zsh` by default ([`zsh --version`](https://www.zsh.org "zsh")).
The plugin manager is Oh My Zsh ([`oh-my-zsh`](https://ohmyz.sh "oh-my-zsh")])

```shell
sh -c "$(curl -fsSL https://raw.githubusercontent.com/ohmyzsh/ohmyzsh/master/tools/install.sh)"
```

### (Optional) Local Configuration Optimization

To understand [_how the startup files work look here._](https://zsh.sourceforge.io/Intro/intro_3.html "Zsh Startup Files").

We optimize by separating concerns like this:

- `.zshprofile`: local user commons for all shells:

```shell
# Eventual Example!
eval "$(/opt/homebrew/bin/brew shellenv)"
source $(brew --prefix)/opt/asdf/libexec/asdf.sh

# Added by Toolbox App
export PATH="$PATH:/Users/YerName/Library/Application Support/JetBrains/Toolbox/scripts"
```

- `.zshenv`: local user state parameters and values:

```shell
# Eventual Example!
export GITHUB_TOKEN="ghp_YerCoolToken"
export DOCKER_TOKEN="dckr_pat_YerCoolDockerToken"
export QODANA_TOKEN="YerCoolQodanaToken"

# YerCool's personal SDK stuff
export VOLTA_HOME="$HOME/.volta"
export KREW_HOME="$HOME/.krew"
export RUBYOPT="-E utf-8:utf-8"

export PATH="$HOME/bin:$VOLTA_HOME/bin:$KREW_HOME/bin:$HOME/.local/bin:$PATH"

# export MANPATH="/usr/local/man:$MANPATH"
export LANG=en_US.UTF-8
export ARCHFLAGS="-arch arm64"

#THIS MUST BE AT THE END OF THE FILE FOR SDKMAN TO WORK!!!
export SDKMAN_DIR="$HOME/.sdkman"
export SDKMAN="$SDKMAN_DIR/bin"
```

- `.zshrc`: local user shell configuration - terminal step:

```shell
# Eventual Example!
# OhMyZsh generated and configured part skipped
# ...
 
zstyle ':omz:update' mode auto      # update automatically without asking
zstyle ':omz:update' frequency 1
# Example plugins chosen
plugins=(asdf brew docker docker-compose gh git gradle kubectl kubectx kube-ps1 mvn node rsync sdk sudo volta yarn conda-zsh-completion)

FPATH="$(brew --prefix)/share/zsh/site-functions:${FPATH}"
source $ZSH/oh-my-zsh.sh

# >>> conda initialize >>>
# !! Contents within this block are managed by 'conda init' !!
__conda_setup="$('/Users/rdd13r/anaconda3/bin/conda' 'shell.zsh' 'hook' 2> /dev/null)"
if [ $? -eq 0 ]; then
    eval "$__conda_setup"
else
    if [ -f "/Users/YerName/anaconda3/etc/profile.d/conda.sh" ]; then
        . "/Users/YerName/anaconda3/etc/profile.d/conda.sh"
    else
        export PATH="/Users/YerName/anaconda3/bin:$PATH"
    fi
fi
unset __conda_setup
# <<< conda initialize <<<


RPS1='$(basename $CONDA_PREFIX) - $(kubectx_prompt_info)'


#Yer Fortunes
if [ -x /opt/homebrew/bin/cowsay -a -x /opt/homebrew/bin/fortune -a -x /opt/homebrew/bin/lolcat ]; then
	cowlist=( $(cowsay -l | sed "1 d") );
	thechosencow=${cowlist[$(($RANDOM % ${#cowlist[*]}))]}
	fortune | cowsay -f "$thechosencow" | lolcat
fi

#THIS MUST BE AT THE END OF THE FILE FOR SDKMAN TO WORK!!!
[[ -s "$SDKMAN/sdkman-init.sh" ]] && source "$SDKMAN/sdkman-init.sh"

conda activate ml
```


<mark>
IMPORTANT!:<br/>
DO NOT copy verbatim<br/>
these are meant as examples to learn from;<br/>
follow OhMyZsh documentation instead.<br/>
</mark>

_It is included here for convenience or as reference when going through setup checks or when installing the second time through._

### Most useful plugins:

_The Zsh Plugins we find most helpful are_:

- `gh`: GitHub CLI
- `git`: Git CLI
- `kubectl`: Kubernetes CLI
- `gradle`: Gradle CLI

## SDK

Our most important SDK manager is [SDK Man](https://sdkman.io "SDK Man").
Install it _**as a local user install**_ as documented on the [SDK Man](https://sdkman.io "SDK Man") website:
`curl -s "https://get.sdkman.io" | bash`

### Install at least:

```shell
sdk install java
sdk install gradle
# optionally
sdk install kotlin
```

_check with..._

```shell
sdk current
```

### Declare project dependencies:

See [Env Commands](https://sdkman.io/usage#env "Env Commands")!

```shell
#.sdkmanrc at project root

# Enable auto-env through the sdkman_auto_env config
# Add key=value pairs of SDKs to use below
java=21.0.4-tem
gradle=8.9
# optionally
kotlin=2.0.0
```

## `asdf`

This tool also manages several different language ecosystems.
It works by the concept of 'plugins' - [see documentation here](https://github.com/asdf-vm/asdf "asdf").
We use it as a favorite tool to manage `ruby` versions and libraries.

NOTE:
Having followed [the site support guide]({{ site.baseurl }}/support/ "Support"),
you have already encountered this sdk manager.

### Installation and options:

There are many [good ways to install `asdf`.](https://asdf-vm.com/guide/getting-started.html "Get Started") 
We use [`brew` as the least time-consuming approach](https://brew.sh/ "Homebrew").

```shell
brew install coreutils curl asdf
```

### Install `ruby`

```shell
asdf plugin add ruby https://github.com/asdf-vm/asdf-ruby.git
asdf plugin update --all
asdf install ruby 3.3.4
asdf global ruby 3.3.4
asdf list ruby  
```

### More on `ruby` and Mac OS X

[https://blog.macadmin.me/posts/asdf-on-macos/](https://blog.macadmin.me/posts/asdf-on-macos/ "asdf on macOS")


## Conda

... and Python 😜
 

IMPORTANT:
[Conda Install](https://conda.io/projects/conda/en/latest/user-guide/install/index.html "Conda Install") Options!

We use [`conda` (community)](https://conda.org/ "Conda") 
and [`conda-forge` tool](https://conda-forge.org/download/ "Conda-Forge")<br/>
> <mark> i.e. Miniforge! </mark> <br/>
> [_**https://github.com/conda-forge/miniforge**_](https://github.com/conda-forge/miniforge "Miniforge")<br/>

to manage our `python` ML environment and dependencies.

### Miniforge Install

Download _**Miniforge**_ fat  _[Release](https://github.com/conda-forge/miniforge/releases "Releases")_, or


```shell
curl -L -O "https://github.com/conda-forge/miniforge/releases/latest/download/Miniforge3-$(uname)-$(uname -m).sh"
bash Miniforge3-$(uname)-$(uname -m).sh
```

_Follow all the excellent documentation on the `conda` website - there's really little to add._

### Preferred Alternative by Lugaru

_Lugaru did this instead:_

```shell
brew install miniforge
```

### Annoyed by PS choice?

**NOTE**: When using custom left and right PS disable `conda`'s like so: `conda config --set changeps1 false`

### What's in `forge`?

[https://conda.anaconda.org/conda-forge/](https://conda.anaconda.org/conda-forge/ "conda-forge")

## Volta

[volta.sh](https://docs.volta.sh/guide/getting-started "volta.sh"), getting started guide.

```shell
curl https://get.volta.sh | bash
```

_Follow the project's [documentation](https://docs.volta.sh/guide/understanding "volta understanding") and [references](https://docs.volta.sh/reference/ "volta reference")._

**NOTE:** Unlike other JS ecosystem management tools `volta` _**ALWAYS keeps track of call source folder!**_, 
thus offering global packages feel without the actual global risks.

## Docker

[Docker Desktop](https://www.docker.com/products/docker-desktop/ "Docker Desktop") 
is still the easiest way to provision Docker and Kubernetes on Mac OS X 
and the primary way that we recommend containerizing locally.

Please note that [Docker Company](https://www.docker.com/company/ "Docker Company") arrives with the new funding model
to which we recommend [_**having a personal-professional subscription**_](https://www.docker.com/pricing/ "Docker Pricing").


Alternatively,
the [Abiosoft](https://github.com/abiosoft "Abiosoft")'s [**Colima**](https://github.com/abiosoft/colima "Colima") is a viable alternative to Docker Desktop approach.

## Jupyter

... and forks:

Having `conda` and containers [Jupyter Notebooks](https://jupyter.org/ "Jupyter Notebooks"), 
or [Google Colab](https://colab.research.google.com/ "Google Colab"),
are a straightforward installation option.
This is also true for additional kernels like `R`, `Kotlin`, `Scala`, etc.

However, there is a better way - please see the IDE section next!

## IDEs

We use the following IDEs:

- [JetBrains Toolbox App](https://www.jetbrains.com/toolbox-app/ "JetBrains Toolbox App") - managing all IDEs:
  - [Intellij IDEA Ultimate](https://www.jetbrains.com/idea/ "IntelliJ IDEA") - core Java development;
  - [DataSpell](https://www.jetbrains.com/dataspell/ "DataSpell") - Python ML and AI development;
    - this supersedes [**Jupyter Notebook**](https://jupyter.org/ "Jupyter Notebook") based tools;
    - this supersedes [**PyCharm Professional Edition**](https://www.jetbrains.com/pycharm/ "PyCharm Professional Edition");
    - NOTE: PyCharm Professional Edition and Jupyter Notebook are viable alternatives;
  - [WebStorm](https://www.jetbrains.com/webstorm/ "WebStorm") - JavaScript and TypeScript development;
- [VScode](https://code.visualstudio.com/ "VSCode") - a free alternative to professional tools.

## Additional Considerations

There are a number of related considerations and crosscut concerns that need to be addressed and may require tools.
For most of these we will rely on `rdd13r` and other senior members of our community once we come to.
Topics that we already keep in mind are:

- Design Quality and Validation: "how do we know that our way is the right one?";
- Code Quality and Validation: "how do we know that our code is the right one?";
- Documentation: "how do we know that our documentation is just right?";
- Code Maintenance: "how do we know that our code will endure?";
- Opportunity Match: "how do we know that our project will be successful?."

## Log

This is the initial draft of the guide - please see the `CONTRIBUTING.md` file for evolution.

- Navigation by Anominous;
- Driving by Lugaru;
- Captured by rdd13r.
- v0.1.
