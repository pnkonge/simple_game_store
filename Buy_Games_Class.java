// The "Buy_Games_Class" class.
//Peter Paul Nkonge Kungania.
//ISP-Project.
//ICS4U-S1
import javax.swing.JOptionPane;
import java.text.DecimalFormat;

public class Buy_Games_Class
{
    private double price;
    private double num_Games;

    public Buy_Games_Class ()
    {
	price = 0.0;
    }


    public Buy_Games_Class (double amount)
    {
	price = amount;
    }


    public void st_GameLth (int num)
    {
	num_Games = num;
    }


    public double t_Price ()
    {
	double t_Price = price * num_Games;
	return t_Price;
    }


    public double setCoupon (double price)
    {
	double total;
	total = price - (price * 0.10);
	return total;
    }


    public void coupon (double price)
    {
	double total;
	total = price - (price * 0.10);
	DecimalFormat formatter = new DecimalFormat ("#,##0.00");
	JOptionPane.showMessageDialog (null, "Total Price (After Coupon): $" + formatter.format (price));
    }


    public double setEmployee (double price)
    {
	double total;
	total = price - (price * 0.30);
	return total;
    }


    public void employee (double price)
    {
	double total;
	total = price - (price * 0.30);
	DecimalFormat formatter = new DecimalFormat ("#,##0.00");
	JOptionPane.showMessageDialog (null, "Total Price (With 30% Employee Dicount): $" + formatter.format (total));
    }


    public void after_Tax (double price)
    {
	double after_Tax = price * 1.13;
	DecimalFormat formatter = new DecimalFormat ("#,##0.00");
	JOptionPane.showMessageDialog (null, "Total Price (After Tax): $" + formatter.format (after_Tax));
    }
} // Buy_Games_Class class
