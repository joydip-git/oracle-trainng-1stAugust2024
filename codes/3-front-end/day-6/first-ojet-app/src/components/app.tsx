/**
 * @license
 * Copyright (c) 2014, 2024, Oracle and/or its affiliates.
 * Licensed under The Universal Permissive License (UPL), Version 1.0
 * as shown at https://oss.oracle.com/licenses/upl/
 * @ignore
 */
import { registerCustomElement } from "ojs/ojvcomponent";
import { Content } from "./content/index";
//import NameList from "./name-list/NameList";
import PersonList from "./person-list/PersonList";

const AppComponent = () => {
  return <div>
    <Content />
    <br />
    {/* <NameList /> */}
    <PersonList />
  </div>
}

export const App = registerCustomElement("app-root", AppComponent)
