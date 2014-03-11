import java.io.Serializable;
import java.util.ArrayList;

import org.antlr.runtime.Token;
import org.antlr.runtime.tree.CommonTree;
import org.antlr.runtime.tree.Tree;

/**
 *
 */
public class ASTNode extends CommonTree implements Node, Serializable {
  private static final long serialVersionUID = 1L;

  private ASTNodeOrigin origin;

  public ASTNode() {
  }

  /**
   * Constructor.
   *
   * @param t
   *          Token for the CommonTree Node
   */
  public ASTNode(Token t) {
    super(t);
  }

  public ASTNode(ASTNode node) {
    super(node);
    this.origin = node.origin;
  }

  @Override
  public Tree dupNode() {
    return new ASTNode(this);
  }

  @Override
  public ArrayList<Node> getChildren() {
    if (super.getChildCount() == 0) {
      return null;
    }

    ArrayList<Node> ret_vec = new ArrayList<Node>();
    for (int i = 0; i < super.getChildCount(); ++i) {
      ret_vec.add((Node) super.getChild(i));
    }

    return ret_vec;
  }

  public String getName() {
    return (Integer.valueOf(super.getToken().getType())).toString();
  }

  /**
   * @return information about the object from which this ASTNode originated, or
   *         null if this ASTNode was not expanded from an object reference
   */
  public ASTNodeOrigin getOrigin() {
    return origin;
  }

  /**
   * Tag this ASTNode with information about the object from which this node
   * originated.
   */
  public void setOrigin(ASTNodeOrigin origin) {
    this.origin = origin;
  }

  public String dump() {
    StringBuilder sb = new StringBuilder();

    sb.append('(');
    sb.append(toString());
    ArrayList<Node> children = getChildren();
    if (children != null) {
      for (Node node : getChildren()) {
        if (node instanceof ASTNode) {
          sb.append(((ASTNode) node).dump());
        } else {
          sb.append("NON-ASTNODE!!");
        }
      }
    }
    sb.append(')');
    return sb.toString();
  }

}
