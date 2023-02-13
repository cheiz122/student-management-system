import java.awt.Color;
//import java.awt.MenuBar;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;

public class myframe {
    JFrame frame;

    myframe() {
        JPanel panel;
        JFrame jf;
        jf = new javax.swing.JFrame("Student Registration System");
        panel = new javax.swing.JPanel();
        jf.add(panel);
        panel.setBackground(new Color(91, 239, 255));
        panel.setLayout(null);
        jf.setSize(900, 700);
        JMenuBar menuBar = new JMenuBar();
        JMenuItem update_std1=new JMenuItem("Update Student Information");
        JMenuItem std=new JMenuItem("update student information");
        JMenuItem update_std=new JMenuItem("Update student information");
        JMenuItem register_units = new JMenuItem("Register Units");
        JMenuItem check_course_enrolments = new JMenuItem("check course enrolment");
        JMenuItem check_students = new JMenuItem("check enrolments");
        JMenuItem check_class_list = new JMenuItem("Get class list");
        JMenuItem enrolments = new JMenuItem("check enrolments");
        JMenuItem std_info = new JMenuItem("Student information");
        JMenuItem addcourse = new JMenuItem("Add course");
        JMenuItem deletecourse = new JMenuItem("Delete course");
        JMenuItem Add_student = new JMenuItem("Add a new student");
        JMenuItem delete_student = new JMenuItem("Delete a student");
        JMenuItem list = new JMenuItem("Get a class list");

        JMenu student = new JMenu("Student");
        JMenu c_o_d = new JMenu("C.O.D/course_advisor");
        JMenu registrar = new JMenu("Registrar");
        JMenu admission = new JMenu("Admission");
        JMenu school = new JMenu("School/Colleges");
        JMenu enrolment = new JMenu("enrolment");
        
         registrar.add(update_std1);
        admission.add(update_std);
        student.add(register_units);
        c_o_d.add(list);
        admission.add(check_students);
        enrolment.add(check_course_enrolments);
        enrolment.add(std);
        school.add(enrolments);
        school.add(check_class_list);
        school.add(std_info);
        registrar.add(addcourse);
        registrar.add(deletecourse);
        admission.add(Add_student);
        admission.add(delete_student);
        menuBar.add(student);
        menuBar.add(c_o_d);
        menuBar.add(admission);
        menuBar.add(registrar);
        menuBar.add(school);
        menuBar.add(enrolment);
        addcourse.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {

                addcourse course = new addcourse();
                System.out.println(course);
            }

        }

        );
        register_units.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {

                units Unit  = new units();
                System.out.println(Unit);
            }

        }

        );
        deletecourse.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {

                deletecourse course = new deletecourse();
                System.out.println(course);
            }

        }

        );
        delete_student.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

                delete_student student = new delete_student();
                System.out.println(student);
            }

        });

        Add_student.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

                Reg_form form = new Reg_form();
                System.out.println(form);
            }

        });

        std_info.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

                std_info student = new std_info();
                System.out.println(student);
            }

        });
        check_class_list.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

                classList list = new classList();
                System.out.println(list);
            }

        });
        enrolments.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

                enrolment enrols = new enrolment();
                System.out.println(enrols);
            }

        });
        check_students.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

                enrolment enrols = new enrolment();
                System.out.println(enrols);
            }

        });
        check_course_enrolments.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

                enrolment enrols = new enrolment();
                System.out.println(enrols);
            }

        });
        list.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

                classList list = new classList();
                System.out.println(list);
            }

        });

        update_std.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

                update list = new update();
                System.out.println(list);
            }

        });
        std.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

                update list = new update();
                System.out.println(list);
            }

        });
        update_std1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

                update list = new update();
                System.out.println(list);
            }

        });
        jf.setJMenuBar(menuBar);
        jf.setVisible(true);
        // jf.show();
    }

    public static void main(String[] args) {
        myframe a = new myframe();
        System.out.println(a);
    }
}
