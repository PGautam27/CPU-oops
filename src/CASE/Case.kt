package CASE

fun main() {
    print("Enter the voltage supplied for the socket: ")
    val voltage:Int = Integer.valueOf(readLine())
    val k = smps(voltage)
    if(!switchOn.switchState(switch)){
        return
    }
    print("Do you want to power on the pc: ")
    val yesNO = readLine()
    var s = k.changeState(yesNO.toString())
    if (!s){
        return
    }
}


