import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class PrinterTest {

    Printer printer;

    @Before
    public void before(){
        printer = new Printer();
    }

    @Test
    public void hasPaperAmount(){
        assertEquals(0, printer.getPaperLeft());
    }

    @Test
    public void hasTonerAmount(){
        assertEquals(0, printer.getTonerLeft());
    }

    @Test
    public void canFillPaper(){
        printer.fillPaper();
        assertEquals(10, printer.getPaperLeft());
       // assertEquals(100, printer.getPaperLeft());

    }

    @Test
    public void canFillToner(){
        printer.fillToner();
        assertEquals(100, printer.getTonerLeft());
      //  assertEquals(10, printer.getTonerLeft());

    }

    @Test
    @Ignore

    public void canPrintPage(){
        printer.fillToner();
        printer.fillPaper();
        printer.printPage();
        assertEquals(99, printer.getPaperLeft());
    }

    @Test
    @Ignore
    public void onlyPrintIfEnoughPaper() {
        printer.fillPaper();
        printer.printCopies(1,101);
        assertEquals(100, printer.getPaperLeft());
    }

    @Test
    @Ignore

    public void printIfEnoughPaper() {
        printer.fillPaper();
        printer.fillToner();
        printer.printCopies(5,2);
        assertEquals(90, printer.getPaperLeft());
    }
    @Test
    @Ignore
    public void stopIfOutOfToner() {
        printer.fillPaper();
        printer.fillToner(); // max set to 10 for this
        printer.printCopies(6,2);
        assertEquals(90, printer.getPaperLeft());
    }

    @Test
    public void stopIfOutOfPaper() {
        printer.fillPaper(); // max set to 10 for this
        printer.fillToner(); // max set to 100 for this
        printer.printCopies(6,2);
        assertEquals(90, printer.getTonerLeft());
    }
}
