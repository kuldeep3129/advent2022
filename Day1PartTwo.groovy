package dayOne

class Day1PartTwo {
    static void main(String[] args){
        File file = new File("C:\\Personal Documnets\\Advent\\Day1Input\\input_day1")
        def lines = file.readLines()
        int sum, temp = 0
        List<Integer> calories = []
        for(String line: lines){
            if(!line.matches("\\d+")){
                calories.add(temp)
                temp = 0
            }else{
                temp = temp + Integer.parseInt(line)
            }
        }
        calories.sort()
        sum = calories.last() + calories.get(calories.size()-2) + calories.get(calories.size()-3)
        println("sum is : ${sum}")
    }
}
