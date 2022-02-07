package CASE

interface sata{
    fun fetch(): ArrayList<Int>
    fun connect()
    fun capacityBalance(){}
}
interface dimPort{
    fun connect()
}
interface pci{
    fun connect()
}