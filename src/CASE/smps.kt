package CASE

class smps(PowerValue: Int){
    var powerSocket:Int = PowerValue
    var powerButton:Boolean = false
    var reset:Boolean = false
    private var earth:Boolean = false
    private var live:Boolean = false
    private var neutral:Boolean = false
    val k:MotherBoard = MotherBoard()
    init {
        breakLive()
    }
    fun changeState(){
        k.start = powerButton && live && earth && neutral
    }
    fun reset(){
        if (reset){

        }
    }
    private fun breakLive(){
        if (powerSocket>210 || powerSocket<=240){
            live = true
            earth = true
            neutral = true
        }

    }
}