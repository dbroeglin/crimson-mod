require 'java'
java_import 'fr.broeglin.ael.mods.crimson.JRubyWorldGen'
java_import 'net.minecraft.init.Blocks'

class Builder < JRubyWorldGen
    attr_writer :gen_block

    def front
        $facing = $sender.commandSenderEntity.adjustedHorizontalFacing.to_s.downcase
        $sender.position.public_send($facing, 3)
    end

    def create(block, position)
        setBlockAndNotifyAdequately(world, position, block.defaultState)
    end

    def gen
        instance_eval(&@gen_block)
    end

    def self.do(&block)
        gen = self::new()
        raise "A block is mandatory when calling 'go'" unless block_given?
        gen.gen_block = block
        gen
    end
end