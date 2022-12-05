package dayOne

class Day1PartOne {
    static void main(String[]args){
        File file = new File("C:\\Personal Documnets\\Advent\\Day1Input\\input_day1")
        def lines = file.readLines()
        int sum, temp, temp1 = 0
        for(String line: lines){
            if(!line.matches("\\d+")){
                if(sum<temp){
                    sum = temp
                }
                temp = 0
                println("blank line found and sum: ${sum}")
            }
            else{
                temp = temp + Integer.parseInt(line.trim())
                temp1 = temp1 + temp
            }

        }
        println("greatest sum is: $temp1")


    }
}
