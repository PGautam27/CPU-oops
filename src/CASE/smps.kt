package CASE
var state = states.POWEROFF
var switch = switchOn.SWITCHOFF
class smps(PowerValue: Int){
    var powerSocket:Int = PowerValue
    var powerButton:Boolean = false
    var reset:Boolean = false
    private var earth:Boolean = false
    private var live:Boolean = false
    private var neutral:Boolean = false
    val k:MotherBoard = MotherBoard()
    init {
        var s = breakLive()
        if (s==-1){
            println("Sorry the voltage $PowerValue is too high or too low")
        }
    }
    fun changeState(a:String):Boolean{
        return if (a=="yes"){
            state = states.POWERON
            k.CPU()
            true
        } else {
            println("Not powering on")
            state = states.POWEROFF
            false
        }
    }
    fun reset(){
        if (reset){

        }
    }
    private fun breakLive():Int{
        return if(powerSocket in 210..240){
            switch = switchOn.SWITCHON
            live = true
            earth = true
            neutral = true
            1
        } else{
            live = false
            earth = false
            neutral = false
            -1
        }
    }
}