package CASE

class monitor{
    fun display(): Int {
        println("Choose any on of the option")
        println("1.Do you wanna use the USB port")
        println("2.Do you wanna see images")
        println("3.Do you wanna fetch data")
        println("4.Do you wanna store data")
        println("5.quit")
        var i: Int = Integer.valueOf(readLine())
        return i
    }
}