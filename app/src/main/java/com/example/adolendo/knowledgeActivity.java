package com.example.adolendo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.ms.square.android.expandabletextview.ExpandableTextView;

public class knowledgeActivity extends AppCompatActivity {
    String long_text1="The symptoms of endometriosis vary. Some women experience mild symptoms, but others can have moderate to severe symptoms. The severity of your pain doesn’t indicate the degree or stage of the condition. You may have a mild form of the disease yet experience agonizing pain. It’s also possible to have a severe form and have very little discomfort.Pelvic pain is the most common symptom of endometriosis. You may also have the following symptoms:\n" +
            "\uF0B7painful periods\n" +
            "\uF0B7pain in the lower abdomen before and during menstruation\n" +
            "\uF0B7cramps one or two weeks around menstruation\n" +
            "\uF0B7heavy menstrual bleeding or bleeding between periods\n" +
            "\uF0B7infertility\n" +
            "\uF0B7pain following sexual intercourse\n" +
            "\uF0B7discomfort with bowel movements\n" +
            "\uF0B7lower back pain that may occur at any time during your menstrual cycle";
    String long_text2="Retrograde menstruation. In retrograde menstruation, menstrual blood containing endometrial cells flows back through the fallopian tubes and into the pelvic cavity instead of out of the body. These endometrial cells stick to the pelvic walls and surfaces of pelvic organs, where they grow and continue to thicken and bleed over the course of each menstrual cycle.\n" +
            "\uF0B7Transformation of peritoneal cells. In what's known as the \"induction theory,\" experts propose that hormones or immune factors promote transformation of peritoneal cells — cells that line the inner side of your abdomen — into endometrial-like cells.\n" +
            "\uF0B7Embryonic cell transformation. Hormones such as estrogen may transform embryonic cells — cells in the earliest stages of development — into endometrial-like cell implants during puberty.\n" +
            "\uF0B7Surgical scar implantation. After a surgery, such as a hysterectomy or C-section, endometrial cells may attach to a surgical incision.\n" +
            "\uF0B7Endometrial cell transport. The blood vessels or tissue fluid (lymphatic) system may transport endometrial cells to other parts of the body.\n" +
            "\uF0B7Immune system disorder. A problem with the immune system may make the body unable to recognize and destroy endometrial-like tissue that's growing outside the uterus.";
    String long_text3="\uF0B7Never giving birth\n" +
            "\uF0B7Starting your period at an early age\n" +
            "\uF0B7Going through menopause at an older age\n" +
            "\uF0B7Short menstrual cycles — for instance, less than 27 days\n" +
            "\uF0B7Heavy menstrual periods that last longer than seven days\n" +
            "\uF0B7Having higher levels of estrogen in your body or a greater lifetime exposure to estrogen your body produces\n" +
            "\uF0B7Low body mass index\n" +
            "\uF0B7One or more relatives (mother, aunt or sister) with endometriosis\n" +
            "\uF0B7Any medical condition that prevents the normal passage of menstrual flow out of the body\n" +
            "\uF0B7Reproductive tract abnormalities";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_knowledge);
        ExpandableTextView expTv1 = (ExpandableTextView)findViewById(R.id.expand_text_view1);
        expTv1.setText(long_text1);

        ExpandableTextView expTv2 = (ExpandableTextView)findViewById(R.id.expand_text_view2);
        expTv2.setText(long_text2);

        ExpandableTextView expTv3 = (ExpandableTextView)findViewById(R.id.expand_text_view3);
        expTv3.setText(long_text3);

    }
}