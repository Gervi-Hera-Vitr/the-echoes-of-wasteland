# frozen_string_literal: true
module Jekyll
  module ExpandNestedVariableFilter
    # Flattens nested variables in the given input string.
    #
    # @param input [String] a string that may contain nested Liquid variables
    # @return [String] the input string with all nested variables flattened
    def flatten_up(input)
      Liquid::Template.parse(input).render(@context)
    end
  end
end

Liquid::Template.register_filter(Jekyll::ExpandNestedVariableFilter)
