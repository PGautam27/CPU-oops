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

enum class inputAndOutputPort(){
    INPUT,OUTPUT,NONE;
    companion object{
        fun inAndOut(obj:inputAndOutputPort):Boolean{
            return obj.compareTo(INPUT)==0 || obj.compareTo(OUTPUT)==0
        }
    }
}