require 'java'
#require_relative 'forge'

$LOGGER.info("Staring mod.rb...")

class RubyMod

    def initialize(logger)
        @logger = logger
    end

    def pre_init(event)
        @logger.debug("ruby: pre_init...")
    end

    def init(event)
        @logger.debug("ruby: init...")
    end

    def post_init(event)
        @logger.debug("ruby: post_init...")
    end

    def server_starting(event)
        @logger.debug("ruby: server_starting...")
    end
end

$LOGGER.info("Finished mod.rb.")

RubyMod