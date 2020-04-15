package example

import groovy.test.GroovyTestCase
import org.codehaus.groovy.ast.builder.AstBuilder
import org.codehaus.groovy.ast.stmt.BlockStatement
import org.codehaus.groovy.ast.stmt.ReturnStatement

class GreetingTests extends GroovyTestCase {

    void testGStringExpression() {
        AstBuilder astBuilder = new AstBuilder()
        List<BlockStatement> statements = astBuilder.buildFromString('"from ${String s} where s == \"test\""') as List<BlockStatement>
        BlockStatement firstBlockStatement = statements[0]
        ReturnStatement returnStatement = (ReturnStatement) firstBlockStatement.statements[0]
        assertTrue returnStatement.expression
    }
}
