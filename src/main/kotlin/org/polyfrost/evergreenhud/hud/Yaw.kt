package org.polyfrost.evergreenhud.hud

import org.polyfrost.evergreenhud.utils.Facing
import org.polyfrost.evergreenhud.utils.decimalFormat
import cc.polyfrost.oneconfig.config.Config
import cc.polyfrost.oneconfig.config.annotations.HUD
import cc.polyfrost.oneconfig.config.annotations.Slider
import cc.polyfrost.oneconfig.config.annotations.Switch
import cc.polyfrost.oneconfig.config.data.Mod
import cc.polyfrost.oneconfig.config.data.ModType
import cc.polyfrost.oneconfig.hud.SingleTextHud
import cc.polyfrost.oneconfig.utils.dsl.mc

class Yaw : Config(Mod("Yaw", ModType.HUD), "evergreenhud/yaw.json", false) {
    @HUD(name = "Main")
    var hud = YawHud()

    init {
        initialize()
    }

    class YawHud : SingleTextHud("Yaw", true, 180, 70) {

        @Slider(name = "Accuracy", min = 0F, max = 10F)
        var accuracy = 2

        @Switch(name = "Trailing Zeros")
        var trailingZeros = true

        override fun getText(example: Boolean): String {
            return decimalFormat(accuracy, trailingZeros).format(mc.thePlayer?.rotationYaw?.let { Facing.wrapDegrees(it) } ?: 0f)
        }
    }
}