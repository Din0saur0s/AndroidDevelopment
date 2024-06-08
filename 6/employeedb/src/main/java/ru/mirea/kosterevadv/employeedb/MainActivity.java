package ru.mirea.kosterevadv.employeedb;

import static androidx.constraintlayout.helper.widget.MotionEffect.TAG;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        AppDatabase db = App.getInstance().getDatabase();
        EmployeeDao employeeDao = db.employeeDao();
        Employee employee1 = new Employee();
        employee1.id = 1;
        employee1.name = "Mr. Incredible";
        employee1.salary = 10000;
        // запись сотрудников в базу
        employeeDao.insert(employee1);

        Employee employee2 = new Employee();
        employee2.id = 2;
        employee2.name = "Elastigirl";
        employee2.salary = 11000;
        // запись сотрудников в базу
        employeeDao.insert(employee2);

        Employee employee3 = new Employee();
        employee3.id = 3;
        employee3.name = "Frozone";
        employee3.salary = 10000;
        // запись сотрудников в базу
        employeeDao.insert(employee3);

        // Загрузка всех работников
        List<Employee> employees = employeeDao.getAll();
        // Получение определенного работника с id = 1
        employee1 = employeeDao.getById(1);
        Log.d(TAG, employee1.name + " " + employee1.salary);
        employee2 = employeeDao.getById(2);
        Log.d(TAG, employee2.name + " " + employee2.salary);
        employee3 = employeeDao.getById(3);
        Log.d(TAG, employee3.name + " " + employee3.salary);
        // Обновление полей объекта
//        employee1.salary = 20000;
//        employeeDao.update(employee1);

    }
}