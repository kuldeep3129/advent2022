package dayTwo

class Day2PartTwo {

    enum Option {
        Rock("A", "X", 1),
        Paper("B", "Y", 2),
        Scissor("C", "Z", 3)

        private final opponentOpt
        private final mineOpt
        private final point

        Option(String opponentOpt, String mineOpt, int point){
            this.opponentOpt = opponentOpt
            this.mineOpt = mineOpt
            this.point = point
        }

    }

    static void main(String[] args){

        String opponentOption, mineOption
        String[] options

        int totalscore, roundScore = 0
        File inputFile = new File("C:\\Personal Documnets\\Advent\\input\\input_day2")

        List<String> rounds = inputFile.readLines()

        Day2PartTwo part2 = new Day2PartTwo()

        for(String round : rounds){
            options = round.split("\\s")
            opponentOption = options[0]
            mineOption = options[1]
            def opponentShape, mineShape
            def values = Option.values()
            for(def enumName : values){
                if(enumName.opponentOpt == opponentOption)
                    opponentShape = enumName
            }
            if(mineOption == "Y")//draw
                roundScore = 3 + opponentShape.point
            else if(mineOption == "X")//loss
                roundScore = 0 + part2.getShapeToChoose("loss", opponentShape.toString()).point
            else if(mineOption == "Z")//win
                roundScore = 6 + part2.getShapeToChoose("win", opponentShape.toString()).point
            totalscore = totalscore + roundScore
        }

        println("Total score is: $totalscore")
    }

    def getShapeToChoose(String desiredResult, String opponentShape){
        if(desiredResult == "win") {
            switch (opponentShape) {
                case ['Rock']:
                    return Option.Paper
                    break
                case ['Paper']:
                    return Option.Scissor
                    break
                case ['Scissor']:
                    return Option.Rock
                    break
            }
        }
        else if(desiredResult == "loss") {
            switch (opponentShape) {
                case ['Rock']:
                    return Option.Scissor
                break
                case ['Paper']:
                    return Option.Rock
                break
                case ['Scissor']:
                    return Option.Paper
                break
            }
        }

    }


}
