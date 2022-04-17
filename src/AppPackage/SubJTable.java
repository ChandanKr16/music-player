package AppPackage;

import java.awt.Color;
import java.awt.Component;
import javax.swing.JTable;
import javax.swing.table.TableCellRenderer;

public class SubJTable extends JTable
{
    @Override
    public Component prepareRenderer(TableCellRenderer ren , int r, int c)
    {
    
        Component comp;
        
        comp = super.prepareRenderer(ren, r, c);

        
        if(r%2==0 && !isCellSelected(r, c))
        {
            comp.setBackground(new Color(23, 23, 23));
        }
        
        else if(!isCellSelected(r , c))
        {
            comp.setBackground(new Color(0,0,0));
        }
        
        else
        {
            comp.setBackground(new Color(46, 46, 46)); // Selected Row
            comp.setFocusable(false);
            comp.setFont(new java.awt.Font("Tahoma", 1, 14));
            
        }
        return comp;
    }
}
