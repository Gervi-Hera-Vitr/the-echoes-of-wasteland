---
layout: single
author: Lugaru
classes: wide
title: "Supporting `this` site"
description: "These are the steps we take to support the Echoes of Wasteland site building locally."
category: support
date: 2024-08-14 13:54:00 -0400
permalink: /support/
toc: true
toc_label: "Contributor's Guide"
toc_icon: "fas fa-book-open"
toc_sticky: true
author_profile: true
sidebar:
  - title: "on Player Character"
    image: rezs/images/TheEchoesProtagonistBadge.png
    image_alt: "The Echoes Protagonist Badge"
    text: "The final purpose of this library is to learn how to develop character arcs and capture the essence in a software artifact."
  - title: "Contributing"
    text: "Please see our [Contributor's Guide](https://github.com/CaptainLugaru/the-echoes-of-wasteland/blob/main/CONTRIBUTING.md) and join our [community](https://github.com/CaptainLugaru/the-echoes-of-wasteland/graphs/contributors/)!"
  - nav: support
  - nav: development
header:
  overlay_image: rezs/images/TheEchoesOfTheWasteland.png  
  show_overlay_excerpt: true
  caption: "The Echoes of Wasteland"
  excerpt: Guide to build and deploy a Jekyll site for the Echoes of Wasteland.
#  overlay_filter:
#    linear-gradient(217deg, rgba(255,0,0,.8), rgba(255,0,0,0) 70.71%),
#    linear-gradient(127deg, rgba(0,255,0,.8), rgba(0,255,0,0) 70.71%),
#    linear-gradient(336deg, rgba(0,0,255,.8), rgba(0,0,255,0) 70.71%);
---

_{{page.description}}_

We use [**_GitHub Actions_**](https://jekyllrb.com/docs/github-pages/ "Jekyll GitHub Actions") to build and deploy a [Jekyll site](https://jekyllrb.com/ "Jekyll").

Start with the documentation site here;<br/>
_then_, move to the [**coding setup in the next section**]({{ site.baseurl }}/development/ "Development Setup"). 

## Setting up your local Mac box

Publishing this site does not require any additional local setup or configuration
as the associated GitHub Actions are automatically managing the build environment.
However, to run the site locally, one needs Ruby to install Bundler and Jekyll.
System Ruby exists as a part of Mac OS X at `/usr/bin/ruby`.
Using OS Ruby for user projects **_is a TERRIBLE idea_**, so we use `asdf` to manage our own **_SDKs_**.

### Provisioning Project Ruby SDK on OS X (`asdf`)

```shell
brew install coreutils curl asdf
. $(brew --prefix)/opt/asdf/libexec/asdf.sh
asdf plugin add ruby https://github.com/asdf-vm/asdf-ruby.git
```

See docs for [`asdf plugin add ruby https://github.com/asdf-vm/asdf-ruby.git`](https://github.com/asdf-vm/asdf-ruby "asdf plugin ruby home") for more details.

If the Ruby plugin is already installed, then:

```shell
asdf plugin-update ruby 
```

OR:

```shell
asdf plugin update --all
```

#### Which `ruby` is present?

```shell
type -a ruby
```

NOTE: `asdf` manages its SDKs in the metafile `~/.tool-versions`.

### Install the Correct Ruby Version

At the time of this writing, the expected Ruby version is 3.3.4; See [**GitHub** Pages _Dependency Versions_](https://pages.github.com/versions/ "GitHub Pages uses the following dependencies and versions").

```shell
asdf install ruby 3.3.4
asdf global ruby 3.3.4
```

NOTE: You may ignore this pesky bug https://github.com/asdf-vm/asdf-ruby/issues/384

```shell
asdf list ruby
```

Should see `3.3.4`, like so:

> ➜  ~ `asdf list ruby`\
> 2.7.4\
> *3.3.4
 
## Install Jekyll for a NEW site

**Navigate to your project `docs` folder and run:**

```shell
docs_folder=${PWD##*/}
docs_folder=${docs_folder:-/}

printf '\nWorking in:\n%s\n' "${PWD##*/}"

printf '\nDocs folder as:\n%s\n' "${PWD##*/}"

gem install jekyll
jekyll new --skip-bundle .
```

Or install Jekyll from anywhere with `gem install jekyll`.

And create the new site with `jekyll new --skip-bundle .`

```shell
jekyll new --force --skip-bundle .
```

## Building EXISTING site locally

_Make sure `bundle` is installed globally or in project for your **docs** folder to work as site root._

```shell
bundle install
```

IMPORTANT: [**_GitHub Pages Documentation!_**](https://docs.github.com/en/pages/setting-up-a-github-pages-site-with-jekyll/creating-a-github-pages-site-with-jekyll "GitHub Pages Documentation")

## Theming Jekyll

- about [Themes](https://jekyllrb.com/docs/themes/)
- our current theme ([Minimal Mistakes](https://github.com/mmistakes/minimal-mistakes))

### Where are my assets?

NEXT: please see the [**coding setup section**]({{ site.baseurl }}/development/ "Development Setup")!

## Additional Resources

- [Markdown Cheat Sheet](https://www.markdownguide.org/cheat-sheet/ "Markdown Guide dot Org")
- [Overriding theme defaults](https://jekyllrb.com/docs/themes/#overriding-theme-defaults "Jekyll Themes")
- [Jekyll default configuration](https://jekyllrb.com/docs/configuration/default/ "Jekyll Configuration")
- [on GitHub Pages & Jekyll](https://docs.github.com/en/pages/setting-up-a-github-pages-site-with-jekyll "Setting up a GitHub Pages site with Jekyll")