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
        this.tonerFillLevel = 100;
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

            printedAll = false;
        }
//        else {
//            do {
//                if (printPage()) {
//                    counter++;
//                } else {
//                    msg += "Printing Error. ";
//                    if (paperLeft > 0)
//                        msg += "Out of Paper. ";
//                    else
//                        msg += "Out of Toner. ";
//                    printedAll = false;
//                }
//            } while (counter < totalPages); // this loop needs a major rethink
//        }
        System.out.println(msg);
        return printedAll;
    }
}
