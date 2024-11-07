module Jekyll
  module ExpandNestedVariableFilter
    def flatten_up(input)
      Liquid::Template.parse(input).render(@context)
    end
  end
end

Liquid::Template.register_filter(Jekyll::ExpandNestedVariableFilter)