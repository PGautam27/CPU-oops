package CASE

data class storage(
    val name:String,
    val x:Int
)

/*class hardDisk:sata{
    var connect:Boolean = false
    private var capacity:Int = 100
    private var balance:Int = capacity
    private var arrayList: ArrayList<Int> = ArrayList<Int>()
    override fun connect() {
        connect = true
    }
    fun store(a:Int){
        if (connect){
            if (a <=1000){
                balance -= 2
                arrayList.add(a)
            }
            else if (a in 1001..100000){
                balance -=5
                arrayList.add(a)
            }
            else {
                balance -=10
                arrayList.add(a)
            }

        }
    }
    fun erase(){
        arrayList = arrayListOf(0)
    }
    override fun capacityBalance() {
        println("The capacity is$capacity GB")
        println("The balance is $balance GB")
    }
    override fun fetch(): ArrayList<Int> {
        if (connect){
            return arrayList
        }
        return arrayListOf(0)
    }
}*/