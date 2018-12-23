package com.example.pengxuanping.greendaotest;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.example.pengxuanping.greendaotest.bean.Student;
import com.example.pengxuanping.greendaotest.db.ChangePathContext;
import com.example.pengxuanping.greendaotest.db.StudentDaoOpe;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;


/* 1. https://blog.csdn.net/huangxiaoguo1/article/details/52916189
   2. https://www.jianshu.com/p/1044c9cdcc97
*/

/*dao: datebase access object */
public class MainActivity extends AppCompatActivity {
    private static final String TAG = "MainActivity";
/*ButterKnife.bind(this) -> @BindView(bind view of id) -> @OnClick(bind id & mtd_click)*/
    @BindView(R.id.add)
    Button add;
    @BindView(R.id.delete)
    Button delete;
    @BindView(R.id.updata)
    Button update;
    @BindView(R.id.check)
    Button check;
    @BindView(R.id.deleteAll)
    Button deleteAll;
    @BindView(R.id.check_id)
    Button checkId;

    private Context mContext;

    private List<Student> mstudentList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        mContext = new ChangePathContext(this);

        new StudentDaoOpe(mContext); // create db & tabs

        initData();
        initListener();
    }

    /* init list of student */
    private void initData() {
        Student student;
        for (int i = 0; i < 100; i++) {
            student = new Student(null, "huang" + i, 25);
            mstudentList.add(student);
        }

    }

    /* regist listener & define callback */
    private void initListener() {

        /* save exist primary key update; inexist, insert  */
        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                for(Student student: mstudentList){ //element, list
                    Log.d(TAG, student.getId() + "--" + student.getName() + "--" + student.getAge());
                }

                StudentDaoOpe.insertInTx(mstudentList);

                for(Student student: mstudentList){ //element, list
                    Log.d(TAG, student.getId() + "--" + student.getName() + "--" + student.getAge());
                }

            }
        });

        /* delete */
        delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Student student = new Student((long) 5, "haung" + 5, 25);

                /* according to entire record del record */
                StudentDaoOpe.deleteData(mContext, student);

                /* according to id del record */
                StudentDaoOpe.deleteByKeyData(mContext, 7);
            }
        });

        /* delete all */
        deleteAll.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                StudentDaoOpe.deleteAllData(mContext);
            }
        });


        /* update */
        update.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Student student = new Student((long) 2, "haungxiaoguo", 16516);
                StudentDaoOpe.updateData(mContext, student);
            }
        });

        /* check */
        check.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                List<Student> lstudents = StudentDaoOpe.queryAll(mContext);
                Student student;
                for (int i = 0; i < lstudents.size(); i++) {
                    student = lstudents.get(i);
                    Log.d("Log", student.getId() + "--" + student.getName() + "--" + student.getAge());
                }
            }
        });


        /* check by Id */
        checkId.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                List<Student> lstudents = StudentDaoOpe.queryForId(mContext, 50);
                Student student;
                for (int i = 0; i < lstudents.size(); i++) {
                    student = lstudents.get(i);
                    Log.d("Log", student.getId() + "--" + student.getName() + "--" + student.getAge());
                }
            }
        });
    }
}
