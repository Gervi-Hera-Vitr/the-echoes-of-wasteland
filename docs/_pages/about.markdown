---
author: Lugaru
layout: single
title: About
permalink: /about/
greeting: "{{ site.data.lugaru.product.name }} - {{ site.data.lugaru.product.description }}" 
header:
  overlay_image: rezs/images/TheEchoesOfTheWasteland.png
  caption: "Welcome!"
---

{{ page.greeting | flatten_up }}

Is an experiment in game development to see if we can encapsulate a player-character entity in a portable library.
