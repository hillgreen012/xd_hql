import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.Set;
import org.antlr.runtime.*;
import org.antlr.runtime.tree.*;

// String[] sqls = {
//     "select c1, c2 from db1.t1 db2.t1",
// 
//     "select c1, c2 from db1.t1, db2.t1",
// 
//     "select c1, c2 from t1;",
// 
//     "select c1, c2 from t1, t2",
// 
//     "select c1, c2 from t1 semi join t2",
// 
//     "from t1 select c1, c2",
// 
//     "from t1 select c1 c2, c3",
// 
//     "seect c1, c2 from t1",
// 
//     "SELECT u.id, actions.date " + 
//         "FROM ( " + 
//         "   SELECT av.uid AS uid " +
//         "   FROM action_video av " +
//         "   WHERE av.date = '2008-06-03' " +
//         "   UNION ALL " +
//         "   SELECT ac.uid AS uid " +
//         "   FROM action_comment ac " + 
//         "   WHERE ac.date = '2008-06-03' " +
//         ") actions JOIN users u ON (u.id = actions.uid);",
// 
//     "SELECT u.id, actions.date " + 
//         "FROM ( " + 
//         "   SELECT av.uid AS uid " +
//         "   FROM db1.aCtion_video av " +
//         "   WHERE av.date = '2008-06-03' " +
//         "   UNION ALL " +
//         "   SELECT ac.uid AS uid " +
//         "   FROM db2.aCtion_comment ac " + 
//         "   WHERE ac.date = '2008-06-03' " +
//         ") actions JOIN db3.usErs u ON (u.id = actions.uid)",
// };

public class XDSHql {
    static private String getSql() throws Exception {
        BufferedReader stdin = new BufferedReader(new InputStreamReader(System.in));
        String s;
        StringBuilder sb = new StringBuilder();
        while ((s = stdin.readLine()) != null && s.length() != 0) sb.append(s + '\n');
        return sb.toString();
    }
    static public void main(String[] argv) {
        try {
            ParseDriver pd = new ParseDriver();
            String sql = getSql();
            ASTNode node = pd.parse(sql);
            Set<String> tbs = ParseUtils.findTablenames(node);
            if (!tbs.isEmpty()) {
                String objln = "[OBJECT] ";
                for (String tb: tbs) {
                    objln += tb + " ";
                }
                System.out.println(objln);
            }
        } catch (Throwable e) {
            System.out.println("[EXCEPTION] " + e.getMessage());
        }
        return;
    }
}
