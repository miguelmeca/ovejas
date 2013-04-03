/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package trazabilidadovinaPantallas;


import javax.swing.event.EventListenerList;
import javax.swing.event.TreeModelListener;
import javax.swing.tree.TreeModel;
import javax.swing.tree.TreePath;

/**
 *
 * @author iuga
 */
public class IconTreeModel implements TreeModel {

    private TreeEntry root;
    protected EventListenerList listenerList = new EventListenerList();

    public IconTreeModel()
    {
        root = new TreeEntry("_ROOT_", null);

        TreeEntry proyectos;
        root.add(proyectos = new TreeEntry("Proyectos","/uce/vista/res/iconos/var/24x24/folder_accept.png"));

        TreeEntry p1,l1,r1,d1;
        proyectos.add(p1=new TreeEntry("Tesis","/uce/vista/res/iconos/var/24x24/accept_page.png"));
        p1.add(l1=new TreeEntry("Listado de Casos de Uso","/uce/vista/res/iconos/var/24x24/page_process.png"));
        p1.add(r1=new TreeEntry("Recursos","/uce/vista/res/iconos/var/24x24/users.png"));
        p1.add(r1=new TreeEntry("Responsabilidades","/uce/vista/res/iconos/var/24x24/calendar_empty.png"));
    }




    public Object getRoot() {
       return root;
    }

    public Object getChild(Object parent, int index) {
        return ((TreeEntry) parent).get(index);
    }

    public int getChildCount(Object parent) {
         return ((TreeEntry) parent).size();
    }

    public boolean isLeaf(Object node) {
        return ((TreeEntry) node).size() == 0;
    }

    public void valueForPathChanged(TreePath path, Object newValue) {
        throw new UnsupportedOperationException("Not supported");
    }

    public int getIndexOfChild(Object parent, Object child) {
       return ((TreeEntry) parent).indexOf(child);
    }

    public void addTreeModelListener(TreeModelListener l) {
       listenerList.add(TreeModelListener.class, l);
    }

    public void removeTreeModelListener(TreeModelListener l) {
       listenerList.remove(TreeModelListener.class, l);
    }

}
