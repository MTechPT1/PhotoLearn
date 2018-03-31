package com.mtech.parttimeone.photolearn.activity;

import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.SubMenu;
import android.view.View;
import android.widget.ListView;
import android.widget.PopupMenu;
import android.widget.Toast;

import com.mtech.parttimeone.photolearn.Adapter.OptionItem;
import com.mtech.parttimeone.photolearn.Adapter.QuizItemDetailAdapter;
import com.mtech.parttimeone.photolearn.Adapter.QuizItemDetailViewPagerAdapter;
import com.mtech.parttimeone.photolearn.Adapter.QuizItemObj;
import com.mtech.parttimeone.photolearn.R;
import com.mtech.parttimeone.photolearn.ViewModel.QuizAttemptViewModel;
import com.mtech.parttimeone.photolearn.ViewModel.QuizItemViewModel;
import com.mtech.parttimeone.photolearn.bo.QuizAttemptBO;
import com.mtech.parttimeone.photolearn.bo.QuizItemBO;
import com.mtech.parttimeone.photolearn.bo.QuizTitleBO;
import com.mtech.parttimeone.photolearn.dummyModel.Item;
import com.mtech.parttimeone.photolearn.fragments.LearningSessionListFragment;
import com.mtech.parttimeone.photolearn.fragments.QuizItemDetailFragment;
import com.mtech.parttimeone.photolearn.handler.LifeCycleHandler;

import java.util.ArrayList;
import java.util.List;

public class QuizItemDetailActivity extends BaseActivity {

    final static String SAVE = "SAVE";
    final static String SUBMIT = "SUBMIT";

    private FragmentManager mFragmentManager;
    private ViewPager viewPager;
    private List<QuizItemBO> itemArray = new ArrayList<>();
    private QuizAttemptBO attemptObj = new QuizAttemptBO();
    public Boolean isReview = false;
    public String titleId;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz_item_detail);
        Intent intent = getIntent();
        titleId = intent.getStringExtra("TitleID");
        loadQuizItems();

        //initData();
        //viewPager.setOffscreenPageLimit(fragmentList.size());
    }

    private void initView() {

        viewPager= (ViewPager) findViewById(R.id.quiz_detail_viewpager);
        mFragmentManager = getSupportFragmentManager();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu items for use in the action bar
       if (!isReview){
            getMenuInflater().inflate(R.menu.menu_edit_quizitemdetail_submit,menu);
            return super.onCreateOptionsMenu(menu);
        }
        return false;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        if (item.getItemId() == R.id.action_unsave) {
            ExitandSave();
            return true;
        } else if (item.getItemId() == R.id.action_unsave){
            ExitandUnsave();
            return true;
        }else if (item.getItemId() == R.id.action_submit){
            Submit();
            return true;
        }
        return false;
    }


    public void initData(){


        QuizItemBO obj_0 = new QuizItemBO();
        obj_0.setItemtitle("How to resolve this issue");
        obj_0.setItemDesc("The Internet of things (IoT) is the network of physical devices, vehicles.");
        obj_0.setDetailedSolution("he Internet of things (IoT) is the network of physical devices, vehicles.");
        List<String> anslist = new ArrayList<>();
        anslist.add("true");
        anslist.add("false");
        anslist.add("true");
        anslist.add("false");
        obj_0.setAnswerOption(anslist);
        QuizAttemptBO attemptBO_0 = new QuizAttemptBO();
        //TODO
        /*  need to iterate through array
        attemptBO_0.setAnswer(anslist);
        obj_0.setQuizAttemptBO(attemptBO_0);
        */
        List<String> optionList = new ArrayList<>();
        optionList.add("ques0_This is option 1");
        optionList.add("ques0_This is option 2");
        optionList.add("ques0_This is option 3");
        optionList.add("ques0_This is option 4");
        obj_0.setAnswer(optionList);
        itemArray.add(obj_0);

        QuizItemBO obj_1 = new QuizItemBO();
        obj_1.setItemtitle("How to resolve this issue 1");
        obj_1.setItemDesc("The Internet of things (IoT) is the network of physical devices, vehicles.");
        obj_1.setDetailedSolution("he Internet of things (IoT) is the network of physical devices, vehicles.");
        List<String> anslist1 = new ArrayList<>();
        anslist1.add("true");
        anslist1.add("false");
        anslist1.add("true");
        anslist1.add("false");
        obj_1.setAnswerOption(anslist1);
        QuizAttemptBO attemptBO_01 = new QuizAttemptBO();;
        //TODO
        /*  need to iterate through array
        attemptBO_01.setAnswer(anslist1);
        obj_1.setQuizAttemptBO(attemptBO_01);
        */
        List<String> optionList1 = new ArrayList<>();
        optionList1.add("ques1_This is option 1");
        optionList1.add("ques1_This is option 2");
        optionList1.add("ques1_This is option 3");
        optionList1.add("ques1_This is option 4");
        obj_1.setAnswer(optionList1);
        itemArray.add(obj_1);

        QuizItemBO obj_2 = new QuizItemBO();
        obj_2.setItemtitle("How to resolve this issue 2");
        obj_2.setItemDesc("The Internet of things (IoT) is the network of physical devices, vehicles.");
        obj_2.setDetailedSolution("he Internet of things (IoT) is the network of physical devices, vehicles.");
        List<String> anslist2 = new ArrayList<>();
        anslist2.add("true");
        anslist2.add("false");
        anslist2.add("true");
        anslist2.add("false");
        anslist2.add("true");
        anslist2.add("false");
        // answer option
        obj_2.setAnswerOption(anslist2);
        QuizAttemptBO attemptBO_02 = new QuizAttemptBO();;
        //TODO
        /*  need to iterate through array
        attemptBO_02.setAnswer(anslist2);
        obj_2.setQuizAttemptBO(attemptBO_02);
         */
        List<String> optionList2 = new ArrayList<>();
        optionList2.add("ques2_This is option 1");
        optionList2.add("ques2_This is option 2");
        optionList2.add("ques2_This is option 3");
        optionList2.add("ques2_This is option 4");
        optionList2.add("ques2_This is option 5");
        optionList2.add("ques2_This is option 6");

        obj_2.setAnswer(optionList2);
        itemArray.add(obj_2);

        QuizItemBO obj_3 = new QuizItemBO();
        obj_3.setItemtitle("How to resolve this issue 3");
        obj_3.setItemDesc("The Internet of things (IoT) is the network of physical devices, vehicles.");
        obj_3.setDetailedSolution("he Internet of things (IoT) is the network of physical devices, vehicles.");
        List<String> anslist3 = new ArrayList<>();
        anslist3.add("true");
        anslist3.add("false");
        anslist3.add("true");
        anslist3.add("false");
        obj_3.setAnswerOption(anslist);
        QuizAttemptBO attemptBO_03 = new QuizAttemptBO();;
        //TODO
        /*  need to iterate through array
        attemptBO_03.setAnswer(anslist3);
        obj_3.setQuizAttemptBO(attemptBO_03);
        */
        List<String> optionList3 = new ArrayList<>();
        optionList3.add("ques3_This is option 1");
        optionList3.add("ques3_This is option 2");
        optionList3.add("ques3_This is option 3");
        optionList3.add("ques3_This is option 4");
        obj_3.setAnswer(optionList3);
        itemArray.add(obj_3);

        QuizItemBO obj_4 = new QuizItemBO();
        obj_4.setItemtitle("How to resolve this issue 4");
        obj_4.setItemDesc("The Internet of things (IoT) is the network of physical devices, vehicles.");
        obj_4.setDetailedSolution("he Internet of things (IoT) is the network of physical devices, vehicles.");
        List<String> anslist4 = new ArrayList<>();
        anslist4.add("true");
        anslist4.add("false");
        anslist4.add("true");
        anslist4.add("false");

        List<String> anslist_4 = new ArrayList<>();
        anslist_4.add("true");
        anslist_4.add("false");
        anslist_4.add("false");
        anslist_4.add("false");

        obj_4.setAnswerOption(anslist_4);
        QuizAttemptBO attemptBO_04 = new QuizAttemptBO();;
        //TODO
        /*  need to iterate through array
        attemptBO_04.setAnswer(anslist4);
        obj_4.setQuizAttemptBO(attemptBO_04);
        */
        List<String> optionList4 = new ArrayList<>();
        optionList4.add("ques4_This is option 1");
        optionList4.add("ques4_This is option 2");
        optionList4.add("ques4_This is option 3");
        optionList4.add("ques4_This is option 4");
        obj_4.setAnswer(optionList4);
        itemArray.add(obj_4);



//        for (int i=0;i<items.size();i++){
//
//            QuizItemDetailFragment itemDetailFragment = QuizItemDetailFragment.newInstance(i);
//            fragmentList.add(itemDetailFragment);
//        }

       // viewPager.setAdapter(new QuizItemDetailViewPagerAdapter(mFragmentManager,items.size(),items));


//        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
//            @Override
//            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
//
//            }
//
//            @Override
//            public void onPageSelected(int position) {
////                QuizItemDetailFragment itemDetailFragment = (QuizItemDetailFragment)fragmentList.get(position);
////                itemDetailFragment.setItemObj(items.get(position));
//            }
//
//            @Override
//            public void onPageScrollStateChanged(int state) {
//
//            }
//        });

    }

    private void ExitandSave(){
        attemptObj.initAttemptBoList(itemArray);
        //attemptObj.setUserId();
        QuizAttemptViewModel vmAttemViewModel = ViewModelProviders.of(this).get(QuizAttemptViewModel.class);
        if (attemptObj.getSaveState().equals(SAVE)){
            vmAttemViewModel.updateQuizAttempt(attemptObj);
        }else{
            try{
                vmAttemViewModel.createQuizAttempt(attemptObj) ;
            }catch (Exception e){
                e.printStackTrace();
                Toast.makeText(this,"Error Saved the Attempt Answer!",Toast.LENGTH_SHORT).show();
            }
        }

    }

    private void ExitandUnsave(){

//        for (int i=0;i<itemArray.size();i++){
//
//        }
        this.onBackPressed();

    }

    private void Submit(){
        int count = getResult();

        for (int i =0;i<itemArray.size();i++){
            QuizItemBO itemBO = itemArray.get(i);
            //TODO
            //QuizAttemptBO attemptBO = itemBO.getQuizAttemptBO();
        }

        showScoreReview("Your total score is " + count+"/"+ itemArray.size()+",go back and review the Answer");
    }

    public void updateData(QuizItemBO obj,int position){

        itemArray.set(position,obj);
        viewPager.getAdapter().notifyDataSetChanged();
    }

    public List<QuizItemBO> getItemArray() {
        return itemArray;
    }

    private void showScoreReview(String content){

       AlertDialog.Builder builder = new AlertDialog.Builder(this);
       builder.setTitle("Score");
       builder.setMessage(content);
       builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
           public void onClick(DialogInterface dialog, int id) {
               // go back to Quiz title page ?
           }
       });

       builder.create();
       builder.show();

   }

   private void loadQuizItems(){
        QuizItemViewModel vmquizItemViewModel = ViewModelProviders.of(this).get(QuizItemViewModel.class);

         vmquizItemViewModel.getQuizItems(titleId).observe(this, new Observer<List<QuizItemBO>>() {
             @Override
             public void onChanged(@Nullable List<QuizItemBO> QuizItemBOS) {
               itemArray = QuizItemBOS;
                 isReview = attemptObj.getSaveState() != null&&attemptObj.getSaveState().equals(SUBMIT);
                 initView();
                 viewPager.setAdapter(new QuizItemDetailViewPagerAdapter(mFragmentManager, itemArray.size()));
             }
         });

//       QuizAttemptViewModel vmAttemViewModel = ViewModelProviders.of(this).get(QuizAttemptViewModel.class);
//       vmAttemViewModel.getQuizAttempt(titleId, LifeCycleHandler.getInstance().getAccountBO().getUserUid()).observe(this, new Observer<QuizAttemptBO>() {
//                   @Override
//                   public void onChanged(@Nullable QuizAttemptBO quizAttemptBO) {
//                       attemptObj =quizAttemptBO;
//                   }
//               });

      // Toast.makeText(this, "Error adding Quiz Item!", Toast.LENGTH_SHORT).show();


   }


   private int getResult(){

       int count = 0;
       for (int i=0;i<itemArray.size();i++){
           QuizItemBO itemObj = itemArray.get(i);
           if (itemObj.isAnsCorrect()){
               count ++;
           }
       }

       return count;
   }

}
