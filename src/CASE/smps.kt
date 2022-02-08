package CASE
internal var state = states.POWEROFF
internal var switch = switchOn.SWITCHOFF
class smps(PowerValue: Int){
    private var powerSocket:Int = PowerValue
    var reset:Boolean = false
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
            k.CPU().eraseAll()
        }
    }
    private fun breakLive():Int{
        return if(powerSocket in 210..240){
            switch = switchOn.SWITCHON
            1
        } else{
            -1
        }
    }
}