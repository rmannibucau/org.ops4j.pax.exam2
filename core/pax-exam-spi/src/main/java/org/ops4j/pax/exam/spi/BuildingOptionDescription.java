/*
 * Copyright (C) 2010 Okidokiteam
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.ops4j.pax.exam.spi;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.ops4j.pax.exam.Option;
import org.ops4j.pax.exam.OptionDescription;
import org.ops4j.pax.exam.TestContainer;

/**
 *
 */
public class BuildingOptionDescription implements OptionDescription
{

    private List<Option> m_unused;
    private List<Option> m_used;

    public BuildingOptionDescription( Option[] allOptions )
    {
        m_unused = new ArrayList<Option>( allOptions.length );
        m_unused.addAll(Arrays.asList( allOptions ) );
        
        m_used = new ArrayList<Option>( allOptions.length );

    }

    public void markAsUsed(Option... options )
    {
        List<Option> list = Arrays.asList( options );
        m_unused.removeAll( list );
        m_used.addAll( list );
    }

    public Option[] getUsedOptions()
    {
        return m_used.toArray( new Option[m_used.size()] );
    }

    public Option[] getIgnoredOptions()
    {
        return m_unused.toArray( new Option[m_unused.size()] );
    }

    public TestContainer getContainer()
    {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }
}