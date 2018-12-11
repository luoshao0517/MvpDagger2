package com.tfkj.dagger2demo.ui.mpchart;

import android.graphics.Color;
import android.util.DisplayMetrics;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.github.mikephil.charting.charts.PieChart;
import com.github.mikephil.charting.components.Description;
import com.github.mikephil.charting.components.Legend;
import com.github.mikephil.charting.data.PieData;
import com.github.mikephil.charting.data.PieDataSet;
import com.github.mikephil.charting.data.PieEntry;
import com.tfkj.dagger2demo.R;
import com.tfkj.dagger2demo.base.BaseActivity;
import com.tfkj.dagger2demo.common.Constance;

import java.util.ArrayList;
import java.util.List;

/**
 * @author luodacheng
 * @date 2018-12-11
 */
@Route(path = Constance.ACTIVITY_URL_CHART)
public class ChartActivity extends BaseActivity {

    private PieChart mChart;

    @Override
    public int getActivityLayout() {
        return R.layout.activity_chart;
    }

    @Override
    protected void initView() {
        super.initView();
        mChart = (PieChart) findViewById(R.id.pieChart);
        PieData mPieData = getPieData(4, 100);
        showChart(mChart, mPieData);
    }

    private void showChart(PieChart pieChart, PieData pieData) {

        pieChart.setHoleRadius(60f);  //半径
        pieChart.setTransparentCircleRadius(64f); // 半透明圈
        //pieChart.setHoleRadius(0)  //实心圆
        Description description = new Description();
        description.setText("测试");
        pieChart.setDescription(description);

        // mChart.setDrawYValues(true);
        pieChart.setDrawCenterText(true);  //饼状图中间可以添加文字

        pieChart.setDrawHoleEnabled(true);

        pieChart.setRotationAngle(90); // 初始旋转角度

        // draws the corresponding description value into the slice
        // mChart.setDrawXValues(true);

        // enable rotation of the chart by touch
        pieChart.setRotationEnabled(true); // 可以手动旋转

        // display percentage values
        pieChart.setUsePercentValues(true);  //显示成百分比
        // mChart.setUnit(" €");
        // mChart.setDrawUnitsInChart(true);

        // add a selection listener
//      mChart.setOnChartValueSelectedListener(this);
        // mChart.setTouchEnabled(false);

//      mChart.setOnAnimationListener(this);

        pieChart.setCenterText("Quarterly Revenue");  //饼状图中间的文字

        //设置数据
        pieChart.setData(pieData);

        // undo all highlights
//      pieChart.highlightValues(null);
//      pieChart.invalidate();

        Legend mLegend = pieChart.getLegend();  //设置比例图
        mLegend.setPosition(Legend.LegendPosition.RIGHT_OF_CHART);  //最右边显示
//      mLegend.setForm(LegendForm.LINE);  //设置比例图的形状，默认是方形
        mLegend.setXEntrySpace(7f);
        mLegend.setYEntrySpace(5f);

        pieChart.animateXY(1000, 1000);  //设置动画
        // mChart.spin(2000, 0, 360);
    }

    /**
     * @param count 分成几部分
     * @param range
     */
    private PieData getPieData(int count, float range) {
        //xVals用来表示每个饼块上的内容
        ArrayList<String> xValues = new ArrayList<String>();
        //饼块上显示成Quarterly1, Quarterly2, Quarterly3, Quarterly4
        for (int i = 0; i < count; i++) {
            xValues.add("Quarterly" + (i + 1));
        }
        //yVals用来表示封装每个饼块的实际数据
        List<PieEntry> yValues = new ArrayList<PieEntry>();

        // 饼图数据
        /**
         * 将一个饼形图分成四部分， 四部分的数值比例为14:14:34:38
         * 所以 14代表的百分比就是14%
         */
        float quarterly1 = 14;
        float quarterly2 = 14;
        float quarterly3 = 34;
        float quarterly4 = 38;

        yValues.add(new PieEntry(quarterly1,xValues.get(0), 0));
        yValues.add(new PieEntry(quarterly2, xValues.get(1),1));
        yValues.add(new PieEntry(quarterly3, xValues.get(2),2));
        yValues.add(new PieEntry(quarterly4,xValues.get(3), 3));

        //y轴的集合
        PieDataSet pieDataSet = new PieDataSet(yValues, "Quarterly Revenue 2014");
        //设置个饼状图之间的距离
        pieDataSet.setSliceSpace(0f);

        ArrayList<Integer> colors = new ArrayList<Integer>();

        // 饼图颜色
        colors.add(Color.rgb(205, 205, 205));
        colors.add(Color.rgb(114, 188, 223));
        colors.add(Color.rgb(255, 123, 124));
        colors.add(Color.rgb(57, 135, 200));

        pieDataSet.setColors(colors);
        DisplayMetrics metrics = getResources().getDisplayMetrics();
        float px = 5 * (metrics.densityDpi / 160f);
        // 选中态多出的长度
        pieDataSet.setSelectionShift(px);
        PieData pieData = new PieData();
        pieData.setDataSet(pieDataSet);
        return pieData;
    }

}