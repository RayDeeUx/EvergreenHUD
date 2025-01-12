package org.polyfrost.evergreenhud.hud

import org.polyfrost.evergreenhud.utils.decimalFormat
import cc.polyfrost.oneconfig.config.Config
import cc.polyfrost.oneconfig.config.annotations.HUD
import cc.polyfrost.oneconfig.config.data.Mod
import cc.polyfrost.oneconfig.config.data.ModType
import cc.polyfrost.oneconfig.hud.SingleTextHud
import cc.polyfrost.oneconfig.utils.dsl.mc

class Saturation: Config(Mod("Saturation", ModType.HUD), "evergreenhud/saturation.json", false) {
    @HUD(name = "Main")
    var hud = SaturationHud()

    init {
        initialize()
    }

    class SaturationHud: SingleTextHud("Saturation", true, 180, 10) {
        override fun getText(example: Boolean): String {
            return decimalFormat(1, true).format(mc.thePlayer?.foodStats?.saturationLevel ?: 20)
        }
    }
}
