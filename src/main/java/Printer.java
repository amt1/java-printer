public class Printer {

    private short paperLeft;
    private short tonerLeft;
    private short paperFillLevel;
    private short tonerFillLevel;
    private String[] resultMsgs= {"OK", "Out of Paper", "Out of Toner", "Out of Paper and Toner"};

    public Printer() {
        this.paperLeft = 0;
        this.tonerLeft = 0;
        this.paperFillLevel = 100;
     //   this.paperFillLevel = 10;

        this.tonerFillLevel = 100;
       // this.tonerFillLevel = 10;

    }

    public short getPaperLeft() {
        return paperLeft;
    }

    public short getTonerLeft() {
        return tonerLeft;
    }

    public void fillPaper() {
        paperLeft = paperFillLevel;
    }

    public void fillToner() {
        tonerLeft = tonerFillLevel;
    }

    public boolean printPage() {
        if ((paperLeft > 0) && (tonerLeft > 0)) {
            paperLeft--;
            tonerLeft--;
            return true;
        }
        return false;
    }

    public boolean printCopies(int pages, int copies){
        int totalPages = pages * copies;
        byte resultCode = 0;
        short counter = 0;
        String msg = "";
        boolean printedAll = true;
        if (totalPages > paperLeft) {
            msg += "Not enough paper: job needs " + totalPages + " and there are only " + paperLeft + " left.";
            resultCode = 4;
            printedAll = false;
        } // this meets the spec of not printing at all if there isn't enough paper
        else { // allowing easy modification for an alternative where it partly prints - to do this remove top half of if statement
            do {
                if (printPage()) {
                    counter++;
                } else {
                    if (paperLeft < 1) resultCode += 1;
                    if (tonerLeft < 1) resultCode += 2;
                    printedAll = false;
                }
            } while ((counter < totalPages) && (resultCode == 0));
        }
        if (resultCode < 4) msg = resultMsgs[resultCode];
        System.out.println(msg);
        return printedAll;
    }
}
