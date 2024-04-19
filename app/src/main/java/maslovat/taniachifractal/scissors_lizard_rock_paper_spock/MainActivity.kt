package maslovat.taniachifractal.scissors_lizard_rock_paper_spock

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import maslovat.taniachifractal.scissors_lizard_rock_paper_spock.databinding.ActivityMainBinding
import maslovat.taniachifractal.scissors_lizard_rock_paper_spock.databinding.InfoDialogBinding
import org.w3c.dom.Text
import kotlin.random.Random

class MainActivity : AppCompatActivity() {
    private var playerChoice = -1
    private var PcChoice = -1
    private lateinit var fld: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        fld = ActivityMainBinding.inflate(layoutInflater)
        setContentView(fld.root)

        fld.scissorsButton.setOnClickListener{choiceBt_Click(ScissorsId,"X")}
        fld.lizardButton.setOnClickListener{choiceBt_Click(LizardId,"X")}
        fld.rockButton.setOnClickListener{choiceBt_Click(RockId,"X")}
        fld.paperButton.setOnClickListener{choiceBt_Click(PaperId,"X")}
        fld.spockButton.setOnClickListener{choiceBt_Click(SpockId,"X")}
        fld.btSelect.setOnClickListener{btSelect_Click()}
        fld.btInfo.setOnClickListener { btInfo_Click() }
    }

    /**Click a picture*/
    private fun choiceBt_Click(actId:Int,symbol:String)
    {
        fld.scissorsButton.text=""
        fld.lizardButton.text=""
        fld.rockButton.text=""
        fld.paperButton.text=""
        fld.spockButton.text=""
        when(actId)
        {
            ScissorsId ->
                fld.scissorsButton.text=symbol
            LizardId ->
                fld.lizardButton.text=symbol
            RockId ->
                fld.rockButton.text=symbol
            PaperId ->
                fld.paperButton.text=symbol
            SpockId ->
                fld.spockButton.text=symbol
            else -> return
        }
        playerChoice=actId
    }

    /**Make a selection*/
    fun btSelect_Click()
    {
        val make_a_choice_Toast = Toast.makeText(applicationContext,getText(R.string.make_a_choice),Toast.LENGTH_SHORT)
        if (playerChoice==-1)
        {
            make_a_choice_Toast.show()
            return
        }
        genPcChoice()
        choiceBt_Click(playerChoice,"#")
        playerChoice=-1
    }

    fun btInfo_Click()
    {
        val dialogFld = InfoDialogBinding.inflate(layoutInflater)
        val dialog = AlertDialog.Builder(this)
            .setTitle(getText(R.string.info))
            .setView(dialogFld.root)
            .create()
        dialog.show()
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