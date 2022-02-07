import CASE.Case

fun main() {
    print("Do you wanna switch on the computer? Yes or No: ")

    var k:String = readLine().toString()
    var flag: Boolean = k.lowercase()=="yes"
    while (flag){
        var case: Case = Case()
        println("Choose any on of the option")
        println("1.Do you wanna use the USB port")
        println("2.Do you wanna see images")
        println("3.Do you wanna store data")
        println("4.Do you wanna browse the data")
        var i: Int = Integer.valueOf(readLine())
        when(i){
        }
    }
}
