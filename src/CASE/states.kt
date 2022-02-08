package CASE

enum class states() {
    POWERON, POWEROFF;
    companion object{
        fun State(obj:states):Boolean{
            return obj.compareTo(POWERON)==0
        }
    }
}
enum class switchOn(){
    SWITCHON,SWITCHOFF;
    companion object{
        fun switchState(obj:switchOn):Boolean{
            return obj.compareTo(SWITCHON)==0
        }
    }
}