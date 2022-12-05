package dayTwo

class Day2PartOne {
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

        int totalscore, roundScore, chooseOptionValue = 0
        File inputFile = new File("C:\\Personal Documnets\\Advent\\input\\input_day2")

        List<String> rounds = inputFile.readLines()

        Day2PartOne game = new Day2PartOne()

        for(String round : rounds){
            options = round.split("\\s")
            opponentOption = options[0]
            mineOption = options[1]
            def opponentShape, mineShape
            def values = Option.values()
            for(def enumName : values){
                if(enumName.opponentOpt == opponentOption)
                    opponentShape = enumName
                if(enumName.mineOpt == mineOption)
                    mineShape = enumName
            }
            chooseOptionValue = mineShape.point
            totalscore = totalscore + chooseOptionValue + game.getScoreOfRound(opponentShape.toString(), mineShape.toString())
        }

        println("Total score is: $totalscore")
    }

    def getScoreOfRound(String opponentShape, String mineShape){
        String result
        if(opponentShape == mineShape)//round draw
            return 3
        else {
            result = resultOfRound(opponentShape, mineShape)
            if (result == "winner") {
                return 6
            }
            else return 0
        }
    }

    def resultOfRound(String opponentAction, String mineAction){
        if(opponentAction == "Rock" && mineAction == "Scissor")
            return "looser"
        else if(opponentAction == "Scissor" && mineAction == "Paper")
            return "looser"
        else if(opponentAction == "Paper" && mineAction == "Rock")
            return "losser"

        else
            return "winner"

    }

}
