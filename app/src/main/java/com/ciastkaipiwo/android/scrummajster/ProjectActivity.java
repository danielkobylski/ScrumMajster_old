package com.ciastkaipiwo.android.scrummajster;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class ProjectActivity extends AppCompatActivity {

    private static final String PROJECT = "com.ciastkaipiwo.android.scrummajster.project";
    private static final int REQUEST_CODE_ADD_SPRINT = 1;
    
    private TextView mSprintDetails;
    private Project mProject;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_project);

        mProject = getIntent().getParcelableExtra(PROJECT);

        mSprintDetails = (TextView) findViewById(R.id.sprint_details);

        mSprintDetails.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ProjectActivity.this, SprintConfigActivity.class);
                startActivityForResult(intent, REQUEST_CODE_ADD_SPRINT);
            }
        });

        updateUI();
        /*if (mProject.getSprints().size()  == 0) {
            mSprintDetails.setText(R.string.no_active_sprint);
        }

        else {
            Sprint activeSprint = mProject.getSprints().get(mProject.getSprints().size());
            int taskCount = activeSprint.mTasksDict.size();
            mSprintDetails.setText(taskCount + " " + R.string.active_tasks);
        }*/

        mSprintDetails.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (mProject.getSprints().size() == 0) {
                    Intent intent = new Intent(ProjectActivity.this, SprintConfigActivity.class);
                    startActivityForResult(intent, REQUEST_CODE_ADD_SPRINT);
                }

                else {
                    mSprintDetails.setText("Now I should show current tasks within this sprint");
                }
            }
        });

    }

    public static Intent newIntent(Context packageContext, Project project){
        Intent intent = new Intent(packageContext, ProjectActivity.class);
        intent.putExtra(PROJECT, project);
        return intent;
    }

    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (resultCode != Activity.RESULT_OK) {
            return;
        }
        if (requestCode == REQUEST_CODE_ADD_SPRINT) {
            if (data == null) {
                return;
            }
            Sprint sprint = SprintConfigActivity.getNewSprint(data);
            mProject.addSprint(sprint);
        }
        updateUI();
    }

    protected void updateUI() {
        if (mProject.getSprints().size() != 0) {
            Sprint activeSprint = mProject.getSprints().get(mProject.getSprints().size()-1);
            int taskCount = activeSprint.mTasksDict.size();
            mSprintDetails.setText(taskCount + " " + getString(R.string.active_tasks));
        }
        else {
            mSprintDetails.setText(getString(R.string.no_active_sprint));
        }
    }

}
