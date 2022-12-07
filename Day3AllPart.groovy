package dayThree

class Day3AllPart {
    String alphabets = "abcdefghijklmnopqrstuvwxyz"
    static void main(String[] args){
        File inputFile = new File("C:\\Personal Documnets\\Advent\\input\\input_day3")
        List<String> rackSacks = inputFile.readLines()
        Day3AllPart day3 = new Day3AllPart()
        day3.findPriorityOfCommonCharacter(rackSacks)
        day3.findPriorityOfCommonInThreeSacks(rackSacks)

    }

    def findPriorityOfCommonInThreeSacks(def rackSacks){
        int sum = 0
        List<String> component = []
        for(String rackSack: rackSacks)
        {
            component.add(rackSack)
            if(component.size() == 3){
                List<Character> component1 = component.get(0).toCharArray()
                List<Character> component2  = component.get(1).toCharArray()
                List<Character> component3  = component.get(2).toCharArray()
                def commonCharacters = component1.intersect(component2)
                def commonCharacter
                println("size is: ${commonCharacters.size()}")
                for(Character comAlphabet : commonCharacters){
                    if(component3.contains(comAlphabet)){
                        commonCharacter = comAlphabet
                        break
                    }
                }

                sum = sum + findPrioritySumOfCommonChar(commonCharacter)
                component = []
            }
        }
        println(sum)

    }

    def findPriorityOfCommonCharacter(def rackSacks){
        int sum = 0
        for(String rackSack: rackSacks)
        {
            List<Character> comp1 = rackSack.substring(0,(rackSack.size()/2).toInteger()).toCharArray()
            List<Character> comp2 = rackSack.substring((rackSack.length()/2).toInteger(), rackSack.length()).toCharArray()
            char commonCharacter = comp1.intersect(comp2).get(0)
            sum = sum + findPrioritySumOfCommonChar(commonCharacter)
        }
        println sum
    }

    def findPrioritySumOfCommonChar(char commonCharacter){
        if(commonCharacter) {
            if (commonCharacter.isUpperCase()) {
                commonCharacter = commonCharacter.toLowerCase()
                println commonCharacter
                return alphabets.indexOf(commonCharacter.toString()) + 27
            } else
                return alphabets.indexOf(commonCharacter.toString()) + 1
        }
    }
}
