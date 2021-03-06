package com.tguzik.m2u.data.jtl;

import java.util.ArrayList;
import java.util.List;

import com.tguzik.m2u.application.MultilineLfNoAddressStyle;
import com.tguzik.objects.BaseObject;
import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamAsAttribute;
import com.thoughtworks.xstream.annotations.XStreamImplicit;
import lombok.Data;
import lombok.Singular;

/**
 * View of the data parsed:
 * <p/>
 * <pre>
 * {@code
 * <?xml version="1.0" encoding="UTF-8"?>
 * <testResults version="1.2">
 *     <sample t="0" lt="0" ts="0" s="true" lb="Label" rc="200" rm="OK" tn="Thread Group" dt="text" de="" by="0"
 *     ng="0" na="0" hn="0">
 *       <responseHeader class="java.lang.String">text</responseHeader>
 *       <requestHeader class="java.lang.String">text</requestHeader>
 *       <responseData class="java.lang.String"></responseData>
 *       <samplerData class="java.lang.String">text</samplerData>
 *     </sample>
 *     <httpSample t="0" lt="0" ts="0" s="true" lb="Label" rc="200" rm="OK" tn="Thread Group" dt="text" de="utf-8"
 *     by="0" ng="0" na="0" hn="0">
 *       <assertionResult>
 *         <name>Assertion name</name>
 *         <failure>false</failure>
 *         <error>false</error>
 *         <failureMessage>text</failureMessage>
 *       </assertionResult>
 *       <responseHeader class="java.lang.String">text</responseHeader>
 *       <requestHeader class="java.lang.String">text</requestHeader>
 *       <responseData class="java.lang.String">text</responseData>
 *       <cookies class="java.lang.String">text</cookies>
 *       <method class="java.lang.String">text</method>
 *       <queryString class="java.lang.String">text</queryString>
 *       <java.net.URL>text</java.net.URL>
 *     </httpSample>
 *
 *     <!-- more sample and httpSample elements -->
 *
 * </testResults>
 * }
 * </pre>
 *
 * @author Tomek
 * @see http://jmeter.apache.org/usermanual/listeners.html#attributes
 */
@Data
@XStreamAlias( "testResults" )
public class TestResults {
    @XStreamAsAttribute
    private String version;

    @Singular
    @XStreamImplicit
    @XStreamAlias( impl = Sample.class, value = "sample" )
    private final List<Sample> samples = new ArrayList<>();

    @Singular
    @XStreamImplicit
    @XStreamAlias( impl = HttpSample.class, value = "httpSample" )
    private final List<HttpSample> httpSamples = new ArrayList<>();

    @Override
    public String toString() {
        return BaseObject.toString( this, MultilineLfNoAddressStyle.INSTANCE );
    }
}
