package CASE

class smps(PowerValue: Int?){
    var powerSocket:Int? = PowerValue
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
            powerSocket = null
        }
    }
    fun changeState(a:String):Boolean{
        return if (a=="yes"){
            k.start = powerButton && live && earth && neutral
            k.CPU()
            true
        } else {
            println("Not powering on")
            false
        }
    }
    fun reset(){
        if (reset){

        }
    }
    private fun breakLive():Int{
        if (powerSocket!! in 210..240){
            live = true
            earth = true
            neutral = true
            return 1
        }
        else{
            live = false
            earth = false
            neutral = false
            return -1
        }
    }
}