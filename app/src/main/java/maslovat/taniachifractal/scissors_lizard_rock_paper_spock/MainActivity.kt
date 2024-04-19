package maslovat.taniachifractal.scissors_lizard_rock_paper_spock

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import maslovat.taniachifractal.scissors_lizard_rock_paper_spock.databinding.ActivityMainBinding
import kotlin.random.Random

class MainActivity : AppCompatActivity() {
    private var playerChoice = -1
    private var PcChoice = -1
    private lateinit var fld: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        fld = ActivityMainBinding.inflate(layoutInflater)
        setContentView(fld.root)

        fld.scissorsButton.setOnClickListener{choiceBt_Click(ScissorsId)}
        fld.lizardButton.setOnClickListener{choiceBt_Click(LizardId)}
        fld.rockButton.setOnClickListener{choiceBt_Click(RockId)}
        fld.paperButton.setOnClickListener{choiceBt_Click(PaperId)}
        fld.spockButton.setOnClickListener{choiceBt_Click(SpockId)}
        fld.btSelect.setOnClickListener{btSelect_Click()}
    }

    /**Click a picture*/
    private fun choiceBt_Click(actId:Int)
    {
        fld.scissorsButton.text=""
        fld.lizardButton.text=""
        fld.rockButton.text=""
        fld.paperButton.text=""
        fld.spockButton.text=""
        when(actId)
        {
            ScissorsId ->
                fld.scissorsButton.text="X"
            LizardId ->
                fld.lizardButton.text="X"
            RockId ->
                fld.rockButton.text="X"
            PaperId ->
                fld.paperButton.text="X"
            SpockId ->
                fld.spockButton.text="X"
            else -> return
        }
        playerChoice=actId
    }

    fun btSelect_Click()
    {
        val make_a_choice_Toast = Toast.makeText(applicationContext,getText(R.string.make_a_choice),Toast.LENGTH_LONG)
        if (playerChoice==-1)
        {
            make_a_choice_Toast.show()
            return
        }
        genPcChoice()
        playerChoice=-1
        choiceBt_Click(-1)
    }

    /**Generate PC choice and update its picture*/
    private fun genPcChoice()
    {
        PcChoice = Random.nextInt(0,5)
        when(PcChoice)
        {
            ScissorsId ->
                fld.compChoiceImg.setBackgroundResource(R.drawable.scissors)
            LizardId ->
                fld.compChoiceImg.setBackgroundResource(R.drawable.lizard)
            RockId ->
                fld.compChoiceImg.setBackgroundResource(R.drawable.rock)
            PaperId ->
                fld.compChoiceImg.setBackgroundResource(R.drawable.paper)
            SpockId ->
                fld.compChoiceImg.setBackgroundResource(R.drawable.spock)
        }
        if(GameActions.strongerAction(PcChoice,playerChoice)==PcChoice)
        {
            fld.compChoiceImg.setText(R.string.you_lost)
        }
        else if (GameActions.strongerAction(PcChoice,playerChoice)==-1)
        {
            fld.compChoiceImg.setText(R.string.a_tie)
        }
        else
        {
            fld.compChoiceImg.setText(R.string.you_won)
        }
    }
}