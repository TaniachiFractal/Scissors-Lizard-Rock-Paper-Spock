package maslovat.taniachifractal.scissors_lizard_rock_paper_spock

val ScissorsId = 0 // beats 1 3
val LizardId = 1 // beats 3 4
val RockId = 2 // beats 0 1
val PaperId = 3 // beats 2 4
val SpockId = 4 // beats 0 2

/**The actions in the game*/
class GameActions
{
    companion object {


        /**Returns which action of the 2 is stronger // Returns the action id or -1 on tie  */
        public fun strongerAction(act1_: Int, act2_: Int): Int {
            var winAct = -1;
            var act1 = act1_;
            var act2 = act2_

            if (act1 == act2)
                return winAct

            when (act1) {
                ScissorsId -> {
                    winAct = if (act2 == LizardId || act2 == PaperId) act1
                    else act2
                }

                LizardId -> {
                    winAct = if (act2 == SpockId || act2 == PaperId) act1
                    else act2
                }

                RockId -> {
                    winAct = if (act2 == ScissorsId || act2 == LizardId) act1
                    else act2
                }

                PaperId -> {
                    winAct = if (act2 == SpockId || act2 == RockId) act1
                    else act2
                }

                SpockId -> {
                    winAct = if (act2 == RockId || act2 == ScissorsId) act1
                    else act2
                }
            }

            return winAct
        }
    }
}