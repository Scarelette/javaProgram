import java.lang.reflect.Field;
import java.util.*;

public class DataBase implements SqlUtil {
    String sentence;

    @Override
    public String query(User user) {
        String qid;
        String qname;
        String querySentence = "SELECT * FROM user WHERE ";
        List<String> condition = new LinkedList<String>();
        Class c = User.class;
        try {
            Field fieldId = c.getDeclaredField("id");
            Field fieldUsername = c.getDeclaredField("username");
            fieldUsername.setAccessible(true);
            String name = (String) fieldUsername.get(user);
            fieldId.setAccessible(true);
            int id = (int) fieldId.get(user);
            if (name != null) {
                qname = name;
                condition.add("'username' LIKE '" + name + "'");
            }
            if (id != 0) {
                qid = String.valueOf(id);
                condition.add("id = " + qid);
            }
        } catch (NoSuchFieldException | IllegalAccessException e) {
            e.printStackTrace();
        }
        Iterator<String> iterator = condition.iterator();
        querySentence += iterator.next();
        if (condition.size() > 1) {
            querySentence += " AND ";
            querySentence += iterator.next();
        }

        return querySentence;
    }

    @Override
    public String insert(User user) {
        sentence = "INSERT INTO `user` ('";
        Class c = User.class;
        List<String> values = new LinkedList<String>();
        Field[] fields = c.getDeclaredFields();

        for (Field f: fields) {
            StringBuilder builder = new StringBuilder();
            builder.append(f.getName());
//            list.add(builder);
            sentence += builder;
            sentence += "','";
            f.setAccessible(true);
            try {
                String value = "";
                if (f.get(user).getClass().toString().equals("class java.lang.Integer")) {
                    value = String.valueOf(f.get(user));
                } else {
                    value = (String) f.get(user);
                }
                values.add(value);
            } catch (IllegalAccessException e) {

                e.printStackTrace();
            }
        }
        sentence = sentence.substring(0,sentence.length()-2);
        sentence += ") VALUES ('";
        for (String item: values) {
            sentence += item;
            sentence += "','";
        }
        sentence = sentence.substring(0,sentence.length() - 2);
        sentence += ")";

        return sentence;
    }

    @Override
    public String insert(List<User> users) {
        sentence = "";
        List<String> list = new LinkedList<String>();
        for (User user: users) {
            String str = insert(user);
            String[] strArray = str.split("\\(");
            sentence = strArray[0] + "(" + strArray[1];
            String value = "(" + strArray[2];
            list.add(value);
        }
        for (String item: list) {
            sentence += item;
            sentence += ",";
        }
        sentence = sentence.substring(0,sentence.length() - 1);
        return sentence;
    }

    @Override
    public String delete(User user) {
        sentence = "DELETE FROM `user` WHERE `id` = ";
        try {
            Class c = user.getClass();
            Field fieldId = c.getDeclaredField("id");
            fieldId.setAccessible(true);
            int id = (int) fieldId.get(user);
            sentence += id;
        } catch ( Exception e ) {
            e.printStackTrace();
        }

        return sentence;
    }

    @Override
    public String update(User user) {
        sentence = "UPDATE `user` SET ";
        Map<String,Object> map = fieldToMap(user);
        Set<Map.Entry<String,Object>> set = map.entrySet();
        int id = 0;
        for (Map.Entry<String, Object> entry: set) {
            if (entry.getKey().intern() == "id") {
                id = (int) entry.getValue();
                continue;
            }
            String str = "'" + entry.getKey() + "'" + " = " + "'" + entry.getValue() + "' ";
            sentence += str;
            sentence += "where 'id' = " + id;
        }


        return sentence;
    }

    private Map<String,Object> fieldToMap(User user) {
        Map<String, Object> map = new HashMap<String, Object>();
        Class c = User.class;
        Field[] fields = c.getDeclaredFields();
        for (Field f : fields) {
            f.setAccessible(true);
            try {
                String value = "";
//                System.out.println(f.get(user).getClass().toString());
                if (f.get(user).getClass().toString().intern() == "class java.lang.Integer") {
                    value = String.valueOf(f.get(user));
                } else {
                    value = (String) f.get(user);
                }
                if (value.intern() != "" && value.intern() != "0") {
                    map.put(f.getName(), f.get(user));
                }
            } catch (IllegalAccessException e) {

                e.printStackTrace();
            }
        }
        return map;
    }
}
