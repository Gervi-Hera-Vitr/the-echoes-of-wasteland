# Supporting `The Echoes of the Wasteland` Site

_This is a short description of how we maintain our game site._

We use [**_GitHub Actions_**](https://jekyllrb.com/docs/github-pages/ "Jekyll GitHub Actions") to build and deploy a [Jekyll site](https://jekyllrb.com/ "Jekyll").

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

See [docs for `asdf plugin add ruby https://github.com/asdf-vm/asdf-ruby.git`](https://github.com/asdf-vm/asdf-ruby "asdf plugin ruby home") for more details.

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
cd ..
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
cd ..
jekyll new --force --skip-bundle .
```

## Building EXISTING site locally

_Make sure `bundle` is installed in your **docs** folder._

```shell
cd ..
bundle install
```

IMPORTANT: [**_GitHub Pages Documentation!_**](https://docs.github.com/en/pages/setting-up-a-github-pages-site-with-jekyll/creating-a-github-pages-site-with-jekyll "GitHub Pages Documentation")




## Additional Resources

- [Markdown Cheat Sheet](https://www.markdownguide.org/cheat-sheet/ "Markdown Guide dot Org")