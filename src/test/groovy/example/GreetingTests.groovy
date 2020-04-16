package example


import org.codehaus.groovy.ast.builder.AstBuilder
import org.codehaus.groovy.ast.stmt.BlockStatement
import org.codehaus.groovy.ast.stmt.ReturnStatement
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test

class GreetingTests {

    @Test
    void testGStringExpression() {
        AstBuilder astBuilder = new AstBuilder()
        List<BlockStatement> statements = astBuilder.buildFromString('"from ${String s} where s == \"test\""') as List<BlockStatement>
        BlockStatement firstBlockStatement = statements[0]
        ReturnStatement returnStatement = (ReturnStatement) firstBlockStatement.statements[0]
        Assertions.assertTrue returnStatement.expression
    }
}
