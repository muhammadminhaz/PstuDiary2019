package com.minhaz.muhammad.pstudiary2019;

import android.content.Context;
import android.support.annotation.NonNull;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.BaseExpandableListAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.security.acl.Group;
import java.util.ArrayList;
import java.util.Iterator;

public class CustomAdapter extends BaseExpandableListAdapter {

    private Context context;
    private ArrayList<Parent> parentList = new ArrayList<>();
    private ArrayList<Parent> originalList;

    public CustomAdapter(Context context,ArrayList<Parent> parentList)
    {
        this.context=context;
        this.parentList.addAll(parentList);
        this.originalList= new ArrayList<>();
        this.originalList.addAll(parentList);


    }

    @Override
    public int getGroupCount() {
        return parentList.size();
    }

    @Override
    public int getChildrenCount(int groupPosition) {
        return ((Parent)this.parentList.get(groupPosition)).getList().size();
    }

    @Override
    public Object getGroup(int groupPosition) {
        return this.parentList.get(groupPosition);
    }

    @Override
    public Object getChild(int groupPosition, int childPosition) {

        return (parentList.get(groupPosition)).getList().get(childPosition);
    }

    @Override
    public long getGroupId(int groupPosition) {
        return groupPosition;
    }

    @Override
    public long getChildId(int groupPosition, int childPosition) {
        return childPosition;
    }

    @Override
    public boolean hasStableIds() {
        return true;
    }

    @Override
    public View getGroupView(int groupPosition, boolean isExpanded, View convertView, ViewGroup parent) {
        Parent continent = (Parent) getGroup(groupPosition);
        if (convertView == null) {
            LayoutInflater layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = layoutInflater.inflate(R.layout.parent_layout, null);
        }

        TextView heading = (TextView) convertView.findViewById(R.id.parentText);
        heading.setText(continent.getName().trim());

        return convertView;
    }

    @Override
    public View getChildView(int groupPosition, int childPosition, boolean isLastChild, View convertView, ViewGroup parent) {
        Child child = (Child)getChild(groupPosition,childPosition);
        if (convertView==null)
        {
            LayoutInflater layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = layoutInflater.inflate(R.layout.child_layout, null);
        }
        TextView name = convertView.findViewById(R.id.nameText);
        TextView occupation = convertView.findViewById(R.id.occupationText);
        TextView mobile = convertView.findViewById(R.id.mobile);
        TextView mail = convertView.findViewById(R.id.eemail);
        TextView dept = convertView.findViewById(R.id.dept);
        name.setText(child.getName());
        occupation.setText(child.getOccupation());
        mobile.setText(child.getMobile());
        mail.setText(child.getMail());
        dept.setText(child.getDept());


        return convertView;
    }

    @Override
    public boolean isChildSelectable(int groupPosition, int childPosition) {
        return true;
    }





    public void fillerData(String query)
    {
        query=query.toLowerCase();
        Log.v("CustomAdapter",String.valueOf(parentList.size()));

        parentList.clear();
        if(query.isEmpty()){
            parentList.addAll(originalList);
        }
        else {
            Iterator it = originalList.iterator();
            while (it.hasNext())
            {
                Parent parent = (Parent) it.next();
                ArrayList<Child> childList = parent.getList();
                ArrayList<Child> newList = new ArrayList<>();
                Iterator it2 = childList.iterator();
                while (it2.hasNext())
                {
                    Child child = (Child) it2.next();
                    if (child.getName().toLowerCase().contains(query)||child.getOccupation().toLowerCase().contains(query))
                    {
                        newList.add(child);
                    }
                }
                if (newList.size()>0)
                {
                    parentList.add(new Parent(parent.getName(),newList));
                }
            }
        }

        Log.v("CustomAdapter", String.valueOf(parentList.size()));
        notifyDataSetChanged();
    }
}











































    /*

    private Context context;
    private ArrayList<Parent> parents;

    public CustomAdapter(Context context, ArrayList<Parent> parents)
    {
        this.context=context;
        this.parents=parents;
    }

    public CustomAdapter(AgricultureList context, ArrayList<String> newList) {
    }


    @Override
    public int getGroupCount() {
        return parents.size();
    }

    @Override
    public int getChildrenCount(int groupPosition) {
        ArrayList<Child> chList = parents.get(groupPosition).getList();
        return chList.size();
    }

    @Override
    public Object getGroup(int groupPosition) {
        return parents.get(groupPosition);
    }

    @Override
    public Object getChild(int groupPosition, int childPosition) {
        ArrayList<Child> chList = parents.get(groupPosition).getList();
        return chList.get(childPosition);
    }

    @Override
    public long getGroupId(int groupPosition) {
        return groupPosition;
    }

    @Override
    public long getChildId(int groupPosition, int childPosition) {
        return childPosition;
    }

    @Override
    public boolean hasStableIds() {
        return false;
    }

    @Override
    public View getGroupView(int groupPosition, boolean isExpanded, View convertView, ViewGroup parent) {
        Parent group = (Parent) getGroup(groupPosition);
        if (convertView == null) {
            LayoutInflater inf = (LayoutInflater) context
                    .getSystemService(context.LAYOUT_INFLATER_SERVICE);
            convertView = inf.inflate(R.layout.parent_layout, null);
        }
        TextView department = (TextView) convertView.findViewById(R.id.parentText);
        department.setText(group.getName());
        return convertView;
    }

    @Override
    public View getChildView(int groupPosition, int childPosition, boolean isLastChild, View convertView, ViewGroup parent) {
        Child child = (Child) getChild(groupPosition, childPosition);

        if (convertView == null) {
            LayoutInflater infalInflater = (LayoutInflater) context
                    .getSystemService(context.LAYOUT_INFLATER_SERVICE);
            convertView = infalInflater.inflate(R.layout.child_layout, null);
        }
        TextView name = (TextView) convertView.findViewById(R.id.nameText);
        //ImageView iv = (ImageView) convertView.findViewById(R.id.flag);
        TextView occupation = (TextView) convertView.findViewById(R.id.occupationText);
        name.setText(child.getName());
        //iv.setImageResource(child.getImage());
        //Trying to do this textview ltv

        occupation.setText(child.getOccupation());




        return convertView;
    }

    @Override
    public boolean isChildSelectable(int groupPosition, int childPosition) {
        return true;
    }


*/


























    /*
    Context context;
    public ArrayList<ArrayList<String>> childList;
    public ArrayList<ArrayList<ArrayList<String>>> childListSub;
    private String[] parents;

    CustomAdapter (Context context,ArrayList<ArrayList<String>> childList,ArrayList<ArrayList<ArrayList<String>>> childListSub,String[] parents) {

        this.context=context;
        this.childList=childList;
        this.childListSub=childListSub;
        this.parents=parents;

    }


    @Override
    public int getGroupCount() {
        return childList.size();
    }

    @Override
    public int getChildrenCount(int groupPosition) {
        return parents.length;
    }

    @Override
    public Object getGroup(int groupPosition) {
        return parents[groupPosition];
    }

    @Override
    public Object getChild(int groupPosition, int childPosition) {
        return childList.get(groupPosition).get(childPosition);
    }

    @Override
    public long getGroupId(int groupPosition) {
        return groupPosition;
    }

    @Override
    public long getChildId(int groupPosition, int childPosition) {
        return childPosition;
    }

    @Override
    public boolean hasStableIds() {
        return false;
    }

    @Override
    public View getGroupView(int groupPosition, boolean isExpanded, View convertView, ViewGroup parentview) {
        if(convertView == null){
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(R.layout.parent_layout, parentview, false);

        }

        TextView parent_textvew = (TextView) convertView.findViewById(R.id.parentText);
        parent_textvew.setText(parents[groupPosition]);
        return  convertView;
    }

    @Override
    public View getChildView(int groupPosition, int childPosition, boolean isLastChild, View convertView, ViewGroup parentview) {
        if(convertView == null){
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(R.layout.child_layout, parentview, false);

        }

        TextView child_textview = (TextView) convertView.findViewById(R.id.nameText);

        TextView child_subitem = convertView.findViewById(R.id.occupationText);
        child_textview.setText(getChild(groupPosition,childPosition).toString());
        child_subitem.setText((CharSequence) childListSub);

        return  convertView;
    }

    @Override
    public boolean isChildSelectable(int groupPosition, int childPosition) {
        return false;
    }

    */
