package CASE

enum class states() {
    POWERON, POWEROFF;
    companion object{
        fun State(obj:states):Boolean{
            return obj.compareTo(POWERON)==0
        }
    }
}